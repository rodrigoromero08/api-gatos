package br.com.romero.apibuscagatos.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String breeds;
	private List<String> temperament;
	private String origin;
	private List<Image> images;

}
