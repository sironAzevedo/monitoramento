package br.com.antifraude.cartao.monitoramento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.antifraude.cartao.monitoramento.model.dto.ClientDTO;
import br.com.antifraude.cartao.monitoramento.service.IClientService;

@RestController
@RequestMapping("/v1/api/client")
public class ClientController {
	
	@Autowired
	private IClientService service;
	
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody void sendSms(@Valid @RequestBody ClientDTO dto) {
        service.saveClient(dto);
    }
}
