package br.com.romero.apibuscagatos.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.romero.apibuscagatos.service.CatService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CatConsumer {

	private CatService catService; 
	
	@Autowired
	public CatConsumer(CatService catService) {
		this.catService = catService; 
	}
	
	@RabbitListener(queues = {"${queue.name}"})
	public void receive(@Payload String body) {
		
		log.info(" -- -> save_cat -- Gato {} --------", body);
		
		catService.createCat(body); 
	}
}
