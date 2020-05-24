package br.com.romero.jobapigatos.services.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.romero.jobapigatos.entities.Breeds;

@FeignClient(name = "breeds", url = "https://api.thecatapi.com/v1/breeds")
public interface BreedsClient {
	
	@GetMapping
	List<Breeds> findAll(); 

}
