package br.com.antifraude.cartao.monitoramento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "TB_OPERACAO")
public class Operation implements Serializable {
	private static final long serialVersionUID = 8321575781806103604L;
	
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(generator = "OPERACAO_ID_SEQ",  strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "OPERACAO_ID_SEQ", sequenceName = "FRDM.OPERACAO_ID_SEQ", allocationSize = 1)
    private Long code;
	
	@NotBlank
	@Column(name = "TIPO_OPERACAO")
    private String typeOperation;
}
