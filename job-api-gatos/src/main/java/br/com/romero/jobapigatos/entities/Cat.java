package br.com.romero.jobapigatos.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.com.romero.jobapigatos.utils.CatUtil;
import lombok.Data;

@Data
public class Cat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id; 
	private String breeds;
	private List<String> temperament; 
	private String origin; 
	private List<Image> images; 

	public Cat(Breeds breeds) {
		setId(breeds.getId());
		setBreeds(breeds.getName());
		setTemperament(Arrays.asList(CatUtil.getListTemperaments(breeds)));
		setOrigin(breeds.getOrigin());
	}

	
	
}
