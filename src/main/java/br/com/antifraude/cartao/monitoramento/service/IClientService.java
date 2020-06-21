package br.com.antifraude.cartao.monitoramento.service;

import javax.validation.Valid;

import br.com.antifraude.cartao.monitoramento.model.dto.ClientDTO;

public interface IClientService {

	void saveClient(@Valid ClientDTO dto);

	ClientDTO getClient(String cpf);

}
