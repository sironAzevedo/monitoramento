package br.com.antifraude.cartao.monitoramento.service.impl;

import org.springframework.stereotype.Service;

import br.com.antifraude.cartao.monitoramento.service.IValidationService;

@Service
public class ValidationServiceImpl implements IValidationService {

	@Override
	public Long createCodeValidation() {
		long max = 999999999999999L;
		long min = 100000000000000L;
		long num;
		
		long numpPossibilities = max - min + 1;
		double numAux = Math.random();
		numAux *= numpPossibilities;
		num = Math.round(numAux);
		return num += min;
	} 
}
