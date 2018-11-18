package com.br.loja.estoque.model;

public enum Tamanho {
	
	P("p"), M("m"), G("g"), GG("gg");
	
	private String tipoTamanho;
	
	private Tamanho(String tipoTamanho){
		this.tipoTamanho = tipoTamanho;
	}
	
	public String getTipoTamanho() {
		return tipoTamanho;
	}
}
