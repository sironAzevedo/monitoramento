package br.com.antifraude.cartao.monitoramento.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.antifraude.cartao.monitoramento.common.enums.SexoEnum;
import br.com.antifraude.cartao.monitoramento.common.enums.SexoEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "TB_CLIENTE")
public class Client implements Serializable {
	private static final long serialVersionUID = 8321575781806103604L;
	
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(generator = "CLIENTE_ID_SEQ",  strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "CLIENTE_ID_SEQ", sequenceName = "FRDM.CLIENTE_ID_SEQ", allocationSize = 1)
    private Long code;
	
	@NotEmpty
	@Column(name = "NOME")
    private String name;
	
	@NotEmpty
	@Column(name = "CPF")
    private String cpf;
	
	@NotEmpty
	@Column(name = "FL_SEXO")
	@Convert(converter = SexoEnumConverter.class)
    private SexoEnum sexo;
	
	@Column(name = "DT_NASCIMENTO")
	private LocalDate dataNascimento;
	
	@NotEmpty
	@Column(name = "CELULAR")
    private String celular;
	
}
