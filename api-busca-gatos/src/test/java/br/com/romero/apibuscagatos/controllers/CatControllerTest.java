package br.com.romero.apibuscagatos.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.romero.apibuscagatos.repositories.CatRepository;
import br.com.romero.apibuscagatos.service.CatService;

@ExtendWith(MockitoExtension.class)
class CatControllerTest {

	@Mock
	CatRepository catRepository; 
	
	CatService catService; 
	CatController catController;
	
	@BeforeEach
	public void init() {
		catService = new CatService(catRepository); 
		catController = new CatController(catService); 
	}
	
	@Test
	void testInvocationFindAll() {
		catController.findAll(); 
		verify(catRepository).findAll(); 
	}
	
	@Test
	void testInvocationFindById() {
		catController.findByBreeds("munc");
		verify(catRepository).findById(any()); 
	}
	
	@Test
	void testInvocationFindByTemperament() {
		catController.findByTemperament("Agile");
		verify(catRepository).findByTemperament(any()); 
	}
	
	@Test
	void testInvocationFindByOrigin() {
		catController.findByOrigin("United States");
		verify(catRepository).findByOrigin(any()); 
	}

}
