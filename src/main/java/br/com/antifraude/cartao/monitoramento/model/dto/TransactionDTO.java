package br.com.antifraude.cartao.monitoramento.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.antifraude.cartao.monitoramento.model.Transaction;
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
public class TransactionDTO implements Serializable{
	private static final long serialVersionUID = -2241261838938530924L;

    private Long code;
    
    @NotBlank 
	private Long codeValidation;
    
    @Valid
    private ClientDTO client;
	
	@NotBlank
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime validate; 
	
	public static TransactionDTO valueOf(Transaction t) {
		return TransactionDTO
				.builder()
				.code(t.getCode())
				.codeValidation(t.getCodeValidation())
				.client(ClientDTO.valueOfCpf(t.getClient()))
				.validate(t.getValidate())
				.build();
	}

}
