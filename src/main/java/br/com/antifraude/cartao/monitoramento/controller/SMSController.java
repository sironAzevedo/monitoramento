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

import br.com.antifraude.cartao.monitoramento.model.dto.SmsDTO;
import br.com.antifraude.cartao.monitoramento.service.ISMSService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/api/sms")
public class SMSController {

	@Autowired
	private ISMSService service;
	
	@ResponseBody
    @PostMapping(value = "/send")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendSms(@Valid @RequestBody SmsDTO dto) {
		log.info("Enivando SMS");
        service.sendSMS(dto);
        log.info("SMS sendo processado...");
    }  
}
