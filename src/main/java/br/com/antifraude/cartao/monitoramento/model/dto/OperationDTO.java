package br.com.antifraude.cartao.monitoramento.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.antifraude.cartao.monitoramento.model.Operation;
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
public class OperationDTO implements Serializable {
	private static final long serialVersionUID = -2749206250871085014L;
	 
    private Long code;
	
	@NotBlank  
	private String typeOperation;
	
	public static OperationDTO valueOf(Operation o) {
		return OperationDTO
				.builder()
				.code(o.getCode())
				.typeOperation(o.getTypeOperation())
				.build();
	}

}
