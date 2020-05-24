package br.com.romero.jobapigatos.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.romero.jobapigatos.entities.Breeds;
import br.com.romero.jobapigatos.entities.Cat;
import br.com.romero.jobapigatos.services.client.BreedsClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatService {

	private BreedsClient breedsClient;
	private ImagesService imagesService;
	private RabbitTemplate rabbitTemplate;
	private Queue queue;

	@Autowired
	public CatService(BreedsClient breedsClient, ImagesService imagesService, RabbitTemplate rabbitTemplate,
			Queue queue) {
		this.breedsClient = breedsClient;
		this.imagesService = imagesService;
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;

	}

	@PostConstruct
	public void start() {
		log.info("----------------------- Iniciando Carregamento da api de gatos ----------------------------");
		loadingCats();
	}

	public void loadingCats() {

		try {
			List<Breeds> breedsList = breedsClient.findAll();
			List<Cat> catList = breedsList.stream().map(b -> new Cat(b)).collect(Collectors.toList());
			catList.parallelStream().forEach(c -> sendCat(c));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void sendCat(Cat cat) {
		try {
			imagesService.carregarImagens(cat);
			log.info("Enviando Gato: {} ", cat.getBreeds());
			String json = getJson(cat);
			rabbitTemplate.convertAndSend(queue.getName(), json);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
	}

	private String getJson(Cat cat) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(cat);
	}
}
