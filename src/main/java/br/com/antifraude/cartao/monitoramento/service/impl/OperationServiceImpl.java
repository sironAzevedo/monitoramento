package br.com.antifraude.cartao.monitoramento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.antifraude.cartao.monitoramento.common.exceptions.EmptyResultDataAccessException;
import br.com.antifraude.cartao.monitoramento.model.dto.OperationDTO;
import br.com.antifraude.cartao.monitoramento.repository.IOperationRepository;
import br.com.antifraude.cartao.monitoramento.service.IOperationService;

@Service
public class OperationServiceImpl implements IOperationService {
	
	@Autowired
	private IOperationRepository repository;

	@Override
	public OperationDTO getOperation(String typeOperation) {
		return repository.findByTypeOperation(typeOperation).map(OperationDTO::valueOf)
				.orElseThrow(() -> new EmptyResultDataAccessException("Operacao nao encontrado"));
	}

}
