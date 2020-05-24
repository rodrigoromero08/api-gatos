package br.com.romero.jobapigatos.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.romero.jobapigatos.entities.Breeds;
import br.com.romero.jobapigatos.entities.Cat;
import br.com.romero.jobapigatos.entities.Image;
import br.com.romero.jobapigatos.enums.TypeImage;
import br.com.romero.jobapigatos.services.client.ImagesClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ImagesServiceTest {
	
	@Mock
	ImagesClient imagesClient; 
	ImagesService imagesService; 
	
	@BeforeEach
	public void init() {	
		Mockito.lenient().when(imagesClient.searchImages(0, 3, "full", "json", TypeImage.HATS.getId().toString(), "abys")).thenReturn(CatGenerator.getListImages(TypeImage.HATS));
		Mockito.lenient().when(imagesClient.searchImages(0, 3, "full", "json", TypeImage.SUNGLASSES.getId().toString(), "abys")).thenReturn(CatGenerator.getListImages(TypeImage.SUNGLASSES));
		imagesService = new ImagesService(imagesClient);
	}
	
	

	@Test
	void testSetImageInCatSucess() {
		try {
		Cat cat = new Cat(CatGenerator.getBreeds()); 
		imagesService.carregarImagens(cat);
		
		assertFalse(cat.getImages().isEmpty());
		Image image = cat.getImages().get(0);
		assertTrue(image.getUrl().equals("https://cdn2.thecatapi.com/images/ba9.jpg"));
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}
	
	@Test
	void testFindTypeSungless() {
		try {
			Cat cat = new Cat(CatGenerator.getBreeds()); 
			imagesService.carregarImagens(cat);
			
			assertFalse(cat.getImages().isEmpty());
			Optional<Image> optional = cat.getImages().stream().filter(i -> i.getType().equals(TypeImage.SUNGLASSES)).findFirst();
			assertTrue(optional.isPresent());
			}catch(Exception e) {
				log.error(e.getMessage(), e);
				fail();
			}
	}
	
	@Test
	void testFindTypeHats() {
		try {
			Cat cat = new Cat(CatGenerator.getBreeds()); 
			imagesService.carregarImagens(cat);
			
			assertFalse(cat.getImages().isEmpty());
			Optional<Image> optional = cat.getImages().stream().filter(i -> i.getType().equals(TypeImage.HATS)).findFirst();
			assertTrue(optional.isPresent());
			}catch(Exception e) {
				log.error(e.getMessage(), e);
				fail();
			}
	}

	

}
