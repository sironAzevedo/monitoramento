package br.com.antifraude.cartao.monitoramento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.antifraude.cartao.monitoramento.model.dto.TransactionDTO;
import br.com.antifraude.cartao.monitoramento.service.ITransactionService;

@RestController
@RequestMapping("/v1/api/transaction")
public class TransactionController {
	
	@Autowired
	private ITransactionService service;
	
	@ResponseBody
    @GetMapping(value = "/verification")
    @ResponseStatus(value = HttpStatus.OK)
    public TransactionDTO validacao(@RequestParam(value = "code") Long codigo) {
        return service.getTransactionByCodeValidation(codigo);
    }
}
