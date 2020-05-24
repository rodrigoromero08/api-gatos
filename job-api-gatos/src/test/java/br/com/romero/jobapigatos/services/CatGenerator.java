package br.com.romero.jobapigatos.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.romero.jobapigatos.entities.Breeds;
import br.com.romero.jobapigatos.entities.Cat;
import br.com.romero.jobapigatos.entities.Image;
import br.com.romero.jobapigatos.enums.TypeImage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CatGenerator {

	private CatGenerator() {

	}

	public static Breeds getBreeds() {

		Breeds breeds = new Breeds();
		breeds.setId("abys");
		breeds.setName("Abyssinian");
		breeds.setOrigin("Egypt");
		breeds.setTemperament("Active, Energetic, Independent, Intelligent, Gentle");

		return breeds;
	}

	public static List<Image> getListImages(TypeImage type) {
		Image image = new Image(type, "https://cdn2.thecatapi.com/images/ba9.jpg");
		return Arrays.asList(image);
	}

	public static List<Breeds> getListBreeds() {

		return Arrays.asList(getBreeds());
	}

	public static Cat getCat() {
		Cat cat = new Cat(getBreeds());
		ArrayList<Image> imagesList = new ArrayList<>();

		imagesList.addAll(getListImages(TypeImage.HATS));
		imagesList.addAll(getListImages(TypeImage.SUNGLASSES));

		cat.setImages(imagesList);

		return cat;
	}

	public static String getCatJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(getCat());
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);

		}

		return null;
	}

}
