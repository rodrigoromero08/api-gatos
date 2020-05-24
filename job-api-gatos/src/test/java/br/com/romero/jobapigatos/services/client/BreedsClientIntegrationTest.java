package br.com.romero.jobapigatos.services.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.romero.jobapigatos.entities.Breeds;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class BreedsClientIntegrationTest {

	@Autowired
	BreedsClient breedsClient;

	

	@Test
	void testSearchAllSuccess() {

		try {

			List<Breeds> breedsList = breedsClient.findAll();
			assertFalse(breedsList.isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}

	@Test
	void testFoundFieldId() {

		try {

			List<Breeds> breedsList = breedsClient.findAll();
			assertFalse(breedsList.isEmpty());
			assertTrue(!breedsList.get(0).getId().isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}

	@Test
	void testFoundFieldName() {

		try {

			List<Breeds> breedsList = breedsClient.findAll();
			assertFalse(breedsList.isEmpty());
			assertTrue(!breedsList.get(0).getName().isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}
	
	@Test
	void testFoundFieldTemperament() {

		try {

			List<Breeds> breedsList = breedsClient.findAll();
			assertFalse(breedsList.isEmpty());
			assertTrue(!breedsList.get(0).getTemperament().isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}
	
	@Test
	void testFoundFieldOrign() {

		try {

			List<Breeds> breedsList = breedsClient.findAll();
			assertFalse(breedsList.isEmpty());
			assertTrue(!breedsList.get(0).getOrigin().isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();
		}
	}

}
