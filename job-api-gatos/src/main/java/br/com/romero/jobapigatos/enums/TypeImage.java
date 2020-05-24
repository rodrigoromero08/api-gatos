package br.com.romero.jobapigatos.enums;

public enum TypeImage {

	SUNGLASSES(4), HATS(1);

	private Integer id;

	TypeImage(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
