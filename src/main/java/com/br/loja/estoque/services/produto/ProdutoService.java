package com.br.loja.estoque.services.produto;

import java.io.IOException;

import com.br.loja.estoque.exceptions.ProdutoDoesntExistsException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ProdutoService {
	
	public String cadastrarProduto(String payload) throws ProdutoDoesntExistsException, JsonParseException, JsonMappingException, IOException;
	public String updateProduto(String payload);
	public String deleteProduto(String payload);
	public String listProduto(String payload);
}
