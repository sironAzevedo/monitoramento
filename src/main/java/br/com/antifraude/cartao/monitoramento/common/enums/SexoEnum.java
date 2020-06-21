package br.com.antifraude.cartao.monitoramento.common.enums;

public enum SexoEnum {
	MASCULIMO("M", "MASCULIMO"), 
	FEMININO("F", "FEMININO"),
	OUTRO("O", "OUTRO");

	private String codigo;
	private String descricao;

	private SexoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static SexoEnum from(String cod) {
		if (cod == null) {
			return null;
		}

		for (SexoEnum p : values()) {
			if (cod.equals(p.getCodigo())) {
				return p;
			}
		}

		return null;
	} 

	@Override
	public String toString() {
		return codigo;
	}
}
