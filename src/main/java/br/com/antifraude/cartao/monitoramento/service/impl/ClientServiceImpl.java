package br.com.antifraude.cartao.monitoramento.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.antifraude.cartao.monitoramento.common.exceptions.EmptyResultDataAccessException;
import br.com.antifraude.cartao.monitoramento.model.Client;
import br.com.antifraude.cartao.monitoramento.model.dto.ClientDTO;
import br.com.antifraude.cartao.monitoramento.repository.IClientRepository;
import br.com.antifraude.cartao.monitoramento.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientRepository repository;
	
	@Override
	public void saveClient(@Valid ClientDTO dto) {
		Client client = Client
				.builder()
				.name(dto.getName())
				.cpf(dto.getCpf())
				.sexo(dto.getSexo())
				.dataNascimento(dto.getDataNascimento())
				.celular(dto.getCelular())
				.build();
		 
		repository.save(client);
	}

	@Override
	public ClientDTO getClient(String cpf) {
		return repository.findByCpf(cpf).map(ClientDTO::valueOf)
				.orElseThrow(() -> new EmptyResultDataAccessException("Cliente nao encontrado"));
	}

}
