package br.com.romero.jobapigatos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romero.jobapigatos.entities.Cat;
import br.com.romero.jobapigatos.entities.Image;
import br.com.romero.jobapigatos.enums.TypeImage;
import br.com.romero.jobapigatos.services.client.ImagesClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImagesService {

	private ImagesClient imagesClient;

	@Autowired
	public ImagesService(ImagesClient imagesClient) {
		this.imagesClient = imagesClient;
		
	}
	
	public void carregarImagens(Cat cat) {
		try {
			ArrayList<Image> images = new ArrayList<>();
			
			log.info("Carregando imagens {} para o Gato {} ", TypeImage.HATS.name(), cat.getBreeds());
			images.addAll(
					imagesClient.searchImages(0, 3, "full", "json", TypeImage.HATS.getId().toString(), cat.getId()));
			
			log.info("Carregando imagens {} para o Gato {} ", TypeImage.SUNGLASSES.name(), cat.getBreeds());
			images.addAll(imagesClient.searchImages(0, 3, "full", "json", TypeImage.SUNGLASSES.getId().toString(),
					cat.getId()));
			log.info("total de imagens encontradas: {}", images.size());
			cat.setImages(images);
		} catch (Exception e) {
			log.warn("Erro ao carregar imagens... ");
			log.error(e.getMessage(), e);
		}
	}
}
