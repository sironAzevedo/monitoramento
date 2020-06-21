package br.com.antifraude.cartao.monitoramento.common.exceptions.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.antifraude.cartao.monitoramento.common.exceptions.DataIntegrityViolationException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.EmptyResultDataAccessException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.FileErrorException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.InternalErrorException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.NotFoundException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.SendSmsErrorException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.TransactionErrorException;
import br.com.antifraude.cartao.monitoramento.common.exceptions.exception.StandardError;
import br.com.antifraude.cartao.monitoramento.common.exceptions.exception.ValidationError;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public StandardError validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Error de validação", new Date());
		e.getBindingResult().getFieldErrors().forEach(f -> error.addError(f.getField(), f.getDefaultMessage()));
		return error;
	} 
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = {InternalErrorException.class, SendSmsErrorException.class})
	public StandardError internalException(InternalErrorException e) {
		
		return StandardError.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.mensagem(e.getMessage())
				.timestamp(new Date())
				.build();
	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {DataIntegrityViolationException.class, EmptyResultDataAccessException.class, NotFoundException.class, FileErrorException.class})
	public StandardError notFoundErrorException(RuntimeException e, HttpServletRequest request) {
		
		return StandardError.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.mensagem(e.getMessage())
				.metodo(request.getMethod())
				.path(request.getRequestURI())
				.timestamp(new Date())
				.build();
	}
	 	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = {TransactionErrorException.class})
	public StandardError forbiddenErrorException(RuntimeException e, HttpServletRequest request) {
		
		return StandardError.builder()
				.status(HttpStatus.FORBIDDEN.value())
				.mensagem(e.getMessage())
				.metodo(request.getMethod())
				.path(request.getRequestURI())
				.timestamp(new Date())
				.build();
	}
}
