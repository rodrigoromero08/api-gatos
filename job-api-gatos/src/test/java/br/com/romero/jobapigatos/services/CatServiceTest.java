package br.com.romero.jobapigatos.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import br.com.romero.jobapigatos.enums.TypeImage;
import br.com.romero.jobapigatos.services.client.BreedsClient;
import br.com.romero.jobapigatos.services.client.ImagesClient;


@ExtendWith(MockitoExtension.class)
class CatServiceTest {

	@Mock
	BreedsClient breedsClient; 
	@Mock
	ImagesClient imagesClient; 
	@Mock
	RabbitTemplate rabbitTemplate;
	
    Queue queue;
	CatService catService; 
	ImagesService imagesService;
	
	
	@BeforeEach
	public void init() {
		Mockito.lenient().when(imagesClient.searchImages(0, 3, "full", "json", TypeImage.HATS.getId().toString(), "abys")).thenReturn(CatGenerator.getListImages(TypeImage.HATS));
		Mockito.lenient().when(imagesClient.searchImages(0, 3, "full", "json", TypeImage.SUNGLASSES.getId().toString(), "abys")).thenReturn(CatGenerator.getListImages(TypeImage.SUNGLASSES));
		Mockito.lenient().when(breedsClient.findAll()).thenReturn(CatGenerator.getListBreeds());
		
		imagesService = new ImagesService(imagesClient);
		queue = new Queue("cat-queue", true); 
		catService = new CatService(breedsClient, imagesService, rabbitTemplate, queue);
	}
	
	@Test
	void testInvocationMethodsLoadingCats() {
		catService.loadingCats();
		verify(breedsClient).findAll();
		verify(imagesClient, times(2)).searchImages(any(), any(), any(), any(), any(), any());
		verify(rabbitTemplate).convertAndSend(queue.getName(), CatGenerator.getCatJson());
	}
	
	
	

}
