package com.br.loja.estoque.services.produto;

import java.io.IOException;
import java.util.List;

import com.br.loja.estoque.exceptions.ExistsProdutoException;
import com.br.loja.estoque.exceptions.ProdutoDoestExistsExcepiton;
import com.br.loja.estoque.model.Produto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ProdutoService {
	
	public String cadastrar(String payload) throws ExistsProdutoException, JsonParseException, JsonMappingException, IOException;
	public String update(String payload) throws ProdutoDoestExistsExcepiton;
	public String delete(Long payload) throws ProdutoDoestExistsExcepiton;
	public List<Produto> list() throws ProdutoDoestExistsExcepiton;
}
