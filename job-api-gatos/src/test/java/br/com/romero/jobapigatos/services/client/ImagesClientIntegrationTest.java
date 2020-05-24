package br.com.romero.jobapigatos.services.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.romero.jobapigatos.entities.Image;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ImagesClientIntegrationTest {

	@Autowired
	private ImagesClient imagesClient;

	@Test
	void testSearchImageAllSuccess() {

		try {
			List<Image> imageList = imagesClient.searchImages(0, 1, "full", "json", null, null);
			assertFalse(imageList.isEmpty());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();

		}
	}
	
	@Test
	void testFoundFieldUrl() {

		try {
			List<Image> imageList = imagesClient.searchImages(0, 1, "full", "json", null, null);
			assertTrue(StringUtils.isNotBlank(imageList.get(0).getUrl()));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			fail();

		}
	}

}
