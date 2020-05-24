package br.com.romero.apibuscagatos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.romero.apibuscagatos.controllers.documentations.ApiCatDocumentation;
import br.com.romero.apibuscagatos.entities.Cat;
import br.com.romero.apibuscagatos.service.CatService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/cats")
public class CatController implements ApiCatDocumentation {

	private CatService catService;

	public CatController(CatService catService) {
		this.catService = catService;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity findByBreeds(@PathVariable String id) {
		log.info("Buscando informação da raça id: {} -> search_breeds", id);
		Optional<Cat> optional = catService.findById(id);

		if (optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		}
		log.warn("Raça id {} não encontrada", id);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	@GetMapping
	public ResponseEntity findAll() {
		log.info("Buscando todas as raças. -> find_all");
		List<Cat> list = catService.findAll();
		log.info("Total de raças encontradas: {}", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	@GetMapping("/temperament/{temperament}")
	public ResponseEntity findByTemperament(@PathVariable String temperament) {
		log.info("Buscando raças pelo temperamento: {} -> find_temperament", temperament);
		List<Cat> list = catService.findByTemperament(temperament);
		log.info("total de raças encontradas pelo temperamento: {}", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	@GetMapping("/origin/{origin}")
	public ResponseEntity findByOrigin(@PathVariable String origin) {
		log.info("Buscando raças pela Origem {}: -> find_origin", origin);
		List<Cat> list = catService.findByOrigin(origin);
		log.info("Total de raças encontradas pela origin: {}", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
