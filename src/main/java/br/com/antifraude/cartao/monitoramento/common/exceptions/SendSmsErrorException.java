package br.com.antifraude.cartao.monitoramento.common.exceptions;

public class SendSmsErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SendSmsErrorException(String message) {
		super(message);
	} 
}
