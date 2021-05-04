package br.com.ian.sgc.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tipo {

	CELULAR("celular"),
	FIXO("fixo");

	private String tipo;
	
	Tipo(String tipo) {
		this.tipo = tipo;
	}
	
	@JsonValue
	public String getTipo() {
		return this.tipo;
	}
}
