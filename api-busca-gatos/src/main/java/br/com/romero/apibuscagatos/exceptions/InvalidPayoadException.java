package br.com.romero.apibuscagatos.exceptions;

public class InvalidPayoadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPayoadException(String msg) {
		super(msg);
	}
}
