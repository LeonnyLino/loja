package com.br.loja.estoque.services.produto;

import java.io.IOException;

import com.br.loja.estoque.exceptions.ProdutoDoesntExistsException;
import com.br.loja.estoque.model.Produto;
import com.br.loja.estoque.repository.EstoqueRepository;
import com.br.loja.estoque.repository.ProdutoRespository;
import com.br.loja.estoque.services.GenericService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ProdutoServiceImpl extends GenericService implements ProdutoService{

	private ProdutoRespository pRepository;
	private EstoqueRepository eRepository;
	
	
	@Override
	public String cadastrarProduto(String payload) throws JsonParseException, JsonMappingException, IOException, ProdutoDoesntExistsException{
		Produto produto = null;
		
		try {
			produto = mapper.readValue(payload, Produto.class);
			
			if(pRepository.findByCodigo(produto.getCodigo()) == null) {
				throw new ProdutoDoesntExistsException();
			}
			
			
			
		}catch(IOException e) {
			
		}
		
		return null;
	}

	@Override
	public String updateProduto(String payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduto(String payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listProduto(String payload) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
