package com.br.loja.estoque.services.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.loja.estoque.exceptions.ExistsProdutoException;
import com.br.loja.estoque.exceptions.ProdutoDoestExistsExcepiton;
import com.br.loja.estoque.model.Produto;
import com.br.loja.estoque.repository.ProdutoRespository;
import com.br.loja.estoque.services.GenericService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ProdutoServiceImpl extends GenericService implements ProdutoService{
	
	@Autowired
	private ProdutoRespository pRepository;
	
//	@Autowired
//	private EstoqueRepository eRepository;
	

	@Override
	@Transactional
	public String cadastrar(String payload)
			throws ExistsProdutoException, JsonParseException, JsonMappingException, IOException {
		Produto produto = null;
		
		try {
			produto = mapper.readValue(payload, Produto.class);
			
			if(pRepository.findByCodigo(produto.getCodigo()) != null) {
				throw new ExistsProdutoException();
			}
			
			pRepository.save(produto);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "Produto cadastrado com sucesso!";
	}
	@Override
	public String update(String payload) throws ProdutoDoestExistsExcepiton {
		Produto produto = null;
		try {
			produto = mapper.readValue(payload, Produto.class);
			
			if(pRepository.findById(produto.getId()) == null) {
				throw new ProdutoDoestExistsExcepiton();
			}
			
			pRepository.save(produto);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "Produto Atualizado com sucesso!";
	}
	@Override
	public String delete(Long payload) throws ProdutoDoestExistsExcepiton {
		Optional<Produto> produto = null;
			produto = pRepository.findById(payload);
			if(produto == null) {
				throw new ProdutoDoestExistsExcepiton();
			}
		
		return null;
	}
	@Override
	public List<Produto> list() throws ProdutoDoestExistsExcepiton {
		ArrayList<Produto> produtos = new ArrayList<Produto>(pRepository.findAll());
		
		if(produtos.isEmpty()) {
			throw new ProdutoDoestExistsExcepiton();
		}
		
		return produtos;
	}
	
	
	
	
	

}
