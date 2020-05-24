package br.com.romero.apibuscagatos.controllers.documentations;

import org.springframework.http.ResponseEntity;

import br.com.romero.apibuscagatos.entities.Cat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Api responável pela consulta de informações das raças dos gatos.")
@ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found") })
public interface ApiCatDocumentation {

	@ApiOperation(value = "Busca informações de uma determinada raça passando o ID")
	@ApiResponse(code = 200, message = "Ok", response = Cat.class)
	ResponseEntity findByBreeds(String id); 
	
	@ApiOperation(value = "Busca todas as raças de Gatos")
	@ApiResponse(code = 200, message = "Ok", response = Cat[].class)
	ResponseEntity findAll();
	
	@ApiOperation(value = "Busca raças de Gatos por um determinado temperamento")
	@ApiResponse(code = 200, message = "Ok", response = Cat[].class)
	ResponseEntity findByTemperament(String temperament);
	
	@ApiOperation(value = "Busca raças de Gatos por uma Origem")
	@ApiResponse(code = 200, message = "Ok", response = Cat[].class)
	ResponseEntity findByOrigin(String origin); 
}
