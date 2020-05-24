package br.com.romero.apibuscagatos.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.romero.apibuscagatos.entities.Cat;

@Repository
public interface CatRepository extends MongoRepository<Cat, String> {

	List<Cat> findByBreeds(String breed);

	List<Cat> findByTemperament(String temperament);

	List<Cat> findByOrigin(String origin);

}
