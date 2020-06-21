package br.com.antifraude.cartao.monitoramento.common.exceptions;

public class TransactionErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TransactionErrorException(String message) {
		super(message);
	} 
}
