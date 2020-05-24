package br.com.romero.jobapigatos.utils;

import org.springframework.util.StringUtils;

import br.com.romero.jobapigatos.entities.Breeds;

public final class CatUtil {

	private CatUtil() {

	}

	public static String[] getListTemperaments(Breeds breeds) {
		String[] temperaments = StringUtils.isEmpty(breeds.getTemperament()) ? new String[0]
				: breeds.getTemperament().split(",");
		for (int i = 0; i < temperaments.length; i++) {
			temperaments[i] = temperaments[i].trim();
		}

		return temperaments;
	}
}
