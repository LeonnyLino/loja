package com.br.loja.estoque.util;

public enum Tamanho {
	
	P("p"), PP("pp"), M("m"), G("g"), GG("gg");
	
	private String tipoTamanho;
	
	private Tamanho(String tipoTamanho){
		this.tipoTamanho = tipoTamanho;
	}
	
	public String getTipoTamanho() {
		return tipoTamanho;
	}
}
