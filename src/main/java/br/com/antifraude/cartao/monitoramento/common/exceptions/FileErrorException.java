package br.com.antifraude.cartao.monitoramento.common.exceptions;

public class FileErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FileErrorException(String message) {
		super(message);
	} 

}
