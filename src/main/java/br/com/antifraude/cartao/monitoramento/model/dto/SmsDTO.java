package br.com.antifraude.cartao.monitoramento.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SmsDTO implements Serializable{
	private static final long serialVersionUID = -7278346117029870138L;
	
	@NotEmpty(message="Cpf é obrigatório")
    private String cpf;
	
    @NotEmpty(message="Operaçâo é obrigatória")
    private String operacao;
}
