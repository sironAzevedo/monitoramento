package br.com.antifraude.cartao.monitoramento.service;

import br.com.antifraude.cartao.monitoramento.model.dto.TransactionDTO;

public interface ITransactionService {

	void saveTransaction(TransactionDTO dto);

	TransactionDTO getTransactionByCodeValidation(Long codeValidation);
}
