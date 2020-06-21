package br.com.antifraude.cartao.monitoramento.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.antifraude.cartao.monitoramento.common.exceptions.EmptyResultDataAccessException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.TransactionErrorException;
import br.com.antifraude.cartao.monitoramento.model.Client;
import br.com.antifraude.cartao.monitoramento.model.Transaction;
import br.com.antifraude.cartao.monitoramento.model.dto.TransactionDTO;
import br.com.antifraude.cartao.monitoramento.repository.ITransactionRepository;
import br.com.antifraude.cartao.monitoramento.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionRepository repository;
	
	@Override
	public void saveTransaction(TransactionDTO dto) {
		try {
			Client client = Client
				.builder()
				.code(dto.getClient().getCode())
				.name(dto.getClient().getName())
				.cpf(dto.getClient().getCpf())
				.sexo(dto.getClient().getSexo())
				.dataNascimento(dto.getClient().getDataNascimento())
				.celular(dto.getClient().getCelular())
				.build(); 
		
		
		Transaction t = Transaction
				.builder()
				.codeValidation(dto.getCodeValidation())
				.validate(dto.getValidate()) 
				.client(client)
				.build(); 
		
		repository.save(t);
		} catch (Exception e) {
			throw new TransactionErrorException(e.getMessage());
		}
	}

	@Override
	public TransactionDTO getTransactionByCodeValidation(Long codeValidation) {
		TransactionDTO transaction = repository.findByCodeValidation(codeValidation).map(TransactionDTO::valueOf)
				.orElseThrow(() -> new EmptyResultDataAccessException("Codigo nao encontrado"));
		
		if(LocalDateTime.now().isAfter(transaction.getValidate())){
            throw new TransactionErrorException("Transacao expirada. É necessario gerar outro codigo");
        }
		
		return transaction;
	}

}
