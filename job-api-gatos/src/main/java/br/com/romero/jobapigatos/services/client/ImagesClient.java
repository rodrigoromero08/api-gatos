package br.com.romero.jobapigatos.services.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.romero.jobapigatos.entities.Image;

@FeignClient(name = "images", url = "https://api.thecatapi.com/v1/images")
public interface ImagesClient {

	@GetMapping(value = "/search")
	public List<Image> searchImages(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
			@RequestParam("size") String size, @RequestParam("format") String format, @RequestParam("category_ids") String categoryIds,
			@RequestParam("breed_id") String breedId);

}
