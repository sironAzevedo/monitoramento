package br.com.antifraude.cartao.monitoramento.common.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SexoEnumConverter implements AttributeConverter<SexoEnum, String> {

	@Override
	public String convertToDatabaseColumn(SexoEnum valor) {
		return valor.getCodigo();
	}

	@Override
	public SexoEnum convertToEntityAttribute(String valor) {
		if ("M".equalsIgnoreCase(valor)) {
			return SexoEnum.MASCULIMO;
		} else if ("F".equalsIgnoreCase(valor)) {
			return SexoEnum.FEMININO;
		} else {
			return SexoEnum.OUTRO;
		}
	}
}