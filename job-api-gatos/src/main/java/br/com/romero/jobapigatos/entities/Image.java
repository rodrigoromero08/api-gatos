package br.com.romero.jobapigatos.entities;

import java.io.Serializable;

import br.com.romero.jobapigatos.enums.TypeImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TypeImage type; 
	private String url; 
	
}
