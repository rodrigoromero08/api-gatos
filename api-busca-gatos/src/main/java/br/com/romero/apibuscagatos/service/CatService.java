package br.com.romero.apibuscagatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.romero.apibuscagatos.entities.Cat;
import br.com.romero.apibuscagatos.enums.ErrorEnum;
import br.com.romero.apibuscagatos.exceptions.InvalidPayoadException;
import br.com.romero.apibuscagatos.repositories.CatRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatService {

	private CatRepository catRepository;

	@Autowired
	public CatService(CatRepository catRepository) {
		this.catRepository = catRepository;

	}

	public void createCat(String body) {
		try {
			Cat cat = catDeserializable(body);
			if (!catIsValid(cat)) {
				log.error("Informações inválidas");
				throw new InvalidPayoadException(ErrorEnum.INFORMATION_NOT_FOUND.getMsg());
			}
			log.info("----- Salvando Gato {} ", cat.getBreeds());
			catRepository.save(cat);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

	public List<Cat> findAll() {
		return catRepository.findAll();
	}

	public Optional<Cat> findById(String id) {
		return catRepository.findById(id);
	}

	public List<Cat> findByTemperament(String temperament) {
		return catRepository.findByTemperament(temperament);
	}

	public List<Cat> findByOrigin(String origin) {
		return catRepository.findByOrigin(origin);
	}

	private boolean catIsValid(Cat cat) {
		return (!StringUtils.isEmpty(cat.getId()) && !cat.getId().isBlank())
				&& (!StringUtils.isEmpty(cat.getBreeds()) && !cat.getBreeds().isBlank());
	}

	private Cat catDeserializable(String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(body, Cat.class);
		} catch (JsonProcessingException e) {
			throw new InvalidPayoadException(ErrorEnum.INFORMATION_NOT_FOUND.getMsg());
		}
	}

}
