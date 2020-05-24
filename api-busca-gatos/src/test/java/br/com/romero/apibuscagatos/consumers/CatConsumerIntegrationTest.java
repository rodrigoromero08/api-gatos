package br.com.romero.apibuscagatos.consumers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.romero.apibuscagatos.repositories.CatRepository;
import br.com.romero.apibuscagatos.service.CatService;

@ExtendWith(MockitoExtension.class)
class CatConsumerIntegrationTest {

	@Mock
	CatRepository catRepository; 
	
	CatService catService; 
	CatConsumer catConsumer; 
	
	@BeforeEach
	public void init() {
		catService = new CatService(catRepository); 
		catConsumer = new CatConsumer(catService); 
	}
	
	@Test
	void testSaveCatSucess() {
		String json = "{\"id\":\"raga\",\"breeds\":\"Ragamuffin\",\"temperament\":[\"Affectionate\",\" Friendly\",\" Gentle\",\" Calm\"],\"origin\":\"United States\",\"images\":[]}";
		
		catConsumer.receive(json);
		verify(catRepository).save(any());
	}
	
	@Test
	void testSaveCatErrorJson() {
		String json = "{";
		catConsumer.receive(json);
		verify(catRepository, times(0)).save(any()); 
	}
	
	@Test
	void testSaveCatNotFoundId() {
		String json = "{\"breeds\":\"Ragamuffin\",\"temperament\":[\"Affectionate\",\" Friendly\",\" Gentle\",\" Calm\"],\"origin\":\"United States\",\"images\":[]}";
		catConsumer.receive(json);
		verify(catRepository, times(0)).save(any()); 
	}
	
	@Test
	void testSaveCatNotFoundBreeds() {
		String json = "{\"id\":\"raga\",\"temperament\":[\"Affectionate\",\" Friendly\",\" Gentle\",\" Calm\"],\"origin\":\"United States\",\"images\":[]}";
		catConsumer.receive(json);
		verify(catRepository, times(0)).save(any()); 
	}

}
