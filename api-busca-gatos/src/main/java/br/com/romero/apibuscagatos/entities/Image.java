package br.com.romero.apibuscagatos.entities;

import java.io.Serializable;

import br.com.romero.apibuscagatos.enums.TypeImage;
import lombok.Data;

@Data
public class Image implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private TypeImage type; 
	private String url; 
}
