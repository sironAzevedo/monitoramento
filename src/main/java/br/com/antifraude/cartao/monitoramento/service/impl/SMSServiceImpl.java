package br.com.antifraude.cartao.monitoramento.service.impl;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.antifraude.cartao.monitoramento.common.exceptions.SendSmsErrorException;
import br.com.antifraude.cartao.monitoramento.model.dto.ClientDTO;
import br.com.antifraude.cartao.monitoramento.model.dto.OperationDTO;
import br.com.antifraude.cartao.monitoramento.model.dto.SmsDTO;
import br.com.antifraude.cartao.monitoramento.model.dto.TransactionDTO;
import br.com.antifraude.cartao.monitoramento.service.IClientService;
import br.com.antifraude.cartao.monitoramento.service.IOperationService;
import br.com.antifraude.cartao.monitoramento.service.ISMSService;
import br.com.antifraude.cartao.monitoramento.service.ITransactionService;
import br.com.antifraude.cartao.monitoramento.service.IValidationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SMSServiceImpl implements ISMSService {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired
	private IValidationService validationService;
	
	@Autowired
	private ITransactionService transactionService;
		
	@Override
	@Async("threadPoolTaskExecutor")
	public void sendSMS(SmsDTO sms) {
		
		try {
			ClientDTO client = clientService.getClient(sms.getCpf());
			OperationDTO operation = operationService.getOperation(sms.getOperacao());
			Long codeValidation = validationService.createCodeValidation();
			String msg = mensagem(client, operation.getTypeOperation(), codeValidation);
			transactionService.saveTransaction(transaction(codeValidation, client));
			mockSendSMS(client, msg);
		} catch (InterruptedException e) {
			throw new SendSmsErrorException(e.getLocalizedMessage());
		} 
	}

	private String mensagem(ClientDTO client, String typeOperation, Long codeValidation) {
		StringBuilder msg = new StringBuilder();
		msg.append("Olá " + client.getName());
		msg.append(", você esta fazendo um ");
		msg.append(typeOperation + " e precisa utlizar o codigo ");
		msg.append(codeValidation + " para confirmar a transação"); 
		return msg.toString();
	}
	
	private TransactionDTO transaction(Long codeValidation, ClientDTO client) {
		return TransactionDTO
				.builder()
				.codeValidation(codeValidation)
				.client(client)
				.validate(LocalDateTime.now().plusMinutes(5L))
				.build();
	}
	
	private void mockSendSMS(ClientDTO client, String msg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        log.info("Enviando SMS para " + client.getCelular());
        log.info(msg);
    } 
}
