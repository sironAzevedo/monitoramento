package br.com.antifraude.cartao.monitoramento.service;

import br.com.antifraude.cartao.monitoramento.model.dto.SmsDTO;

public interface ISMSService {
	
	void sendSMS(SmsDTO sms); 
}
