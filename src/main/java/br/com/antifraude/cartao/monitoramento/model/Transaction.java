package br.com.antifraude.cartao.monitoramento.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "TB_TRANSACAO")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 8321575781806103604L;
	
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(generator = "TRANSACAO_ID_SEQ",  strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "TRANSACAO_ID_SEQ", sequenceName = "FRDM.TRANSACAO_ID_SEQ", allocationSize = 1)
    private Long code;
	
	@NotNull
	@Column(name = "COD_CONFIRMACAO")
	private Long codeValidation;
	 
	@NotNull
	@Column(name = "VALIDADE")
	private LocalDateTime validate; 

	@NotNull
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;	
}
