package br.com.antifraude.cartao.monitoramento.service;

import br.com.antifraude.cartao.monitoramento.model.dto.OperationDTO;

public interface IOperationService {

	OperationDTO getOperation(String typeOperation);

}
