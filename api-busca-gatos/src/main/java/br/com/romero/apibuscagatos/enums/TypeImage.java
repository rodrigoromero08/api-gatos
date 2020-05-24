package br.com.romero.apibuscagatos.enums;

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
