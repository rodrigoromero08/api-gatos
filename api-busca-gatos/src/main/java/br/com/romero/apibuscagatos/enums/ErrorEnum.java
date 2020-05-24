package br.com.romero.apibuscagatos.enums;

public enum ErrorEnum {
	INFORMATION_NOT_FOUND("Informações necessárias para o cadastro não encontradas");
	
	private final String msg; 
	
	ErrorEnum(String msg){
		this.msg = msg;  
	}

	public String getMsg() {
		return msg;
	}

}
