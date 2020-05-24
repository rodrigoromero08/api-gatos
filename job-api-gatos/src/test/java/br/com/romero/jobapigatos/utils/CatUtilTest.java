package br.com.romero.jobapigatos.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import br.com.romero.jobapigatos.entities.Breeds;
import br.com.romero.jobapigatos.services.CatGenerator;

class CatUtilTest {

	@Test
	void testTrimStringTemperament() {
		
		Breeds breeds = CatGenerator.getBreeds(); 
		String[] temperaments = CatUtil.getListTemperaments(breeds);
		String[] esperado = new String[] {"Active", "Energetic", "Independent", "Intelligent", "Gentle"};
		
		assertArrayEquals(esperado, temperaments, "concluido");
	}

}
