package br.com.antifraude.cartao.monitoramento.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.antifraude.cartao.monitoramento.common.enums.SexoEnum;
import br.com.antifraude.cartao.monitoramento.model.Client;
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
public class ClientDTO implements Serializable{
	private static final long serialVersionUID = -6399876012324167969L;
	
	private Long code;
	
    @NotEmpty(message = "O nome não pode ser nulo")
    private String name;
    
    @NotEmpty(message = "O CPF não pode ser nulo")
    private String cpf;
    
    @NotEmpty(message = "O sexo não pode ser nulo")
    private SexoEnum sexo;
    
    private LocalDate dataNascimento;
    
    @NotEmpty(message = "O celular não pode ser nulo")
    private String celular;
    
    public static ClientDTO valueOf(Client c) {
    	return ClientDTO
    			.builder()
    			.code(c.getCode())
    			.name(c.getName())
    			.cpf(c.getCpf())
    			.sexo(c.getSexo())
    			.dataNascimento(c.getDataNascimento())
    			.celular(c.getCelular())
    			.build();
    }
    
    public static ClientDTO valueOfCpf(Client c) {
    	return ClientDTO
    			.builder()
    			.cpf(c.getCpf())
    			.build();
    }

}
