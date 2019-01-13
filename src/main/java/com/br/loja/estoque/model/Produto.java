package com.br.loja.estoque.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.br.loja.estoque.util.Tamanho;

@Entity(name = "produtos")
public class Produto implements InterfaceModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String nome;
	private String cor;
	@Column(name= "valor", nullable = false, precision = 11, scale = 2)
	private BigDecimal valor;
	@Enumerated
	@Column(name = "tamanho", nullable = false)
	private Tamanho tamanho;	
	private String descricao;
	
	public Produto(String codigo, String nome, String cor, Tamanho tamanho, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.cor = cor;
		this.tamanho = tamanho;
		this.descricao = descricao;
	}
	
	public Produto() {	}
	
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public Tamanho getTamanho() {
		return tamanho;
	}


	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
