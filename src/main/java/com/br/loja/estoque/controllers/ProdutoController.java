package com.br.loja.estoque.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.loja.estoque.exceptions.ExistsProdutoException;
import com.br.loja.estoque.exceptions.ProdutoDoestExistsExcepiton;
import com.br.loja.estoque.services.produto.ProdutoService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@ResponseBody
	@PostMapping(value = "/cadastrarProduto", consumes = "application/json")
	public ResponseEntity<String> cadastrar(@RequestBody String payload) throws JsonParseException, JsonMappingException, IOException{
		
		try {
			return ResponseEntity.ok(produtoService.cadastrar(payload));
		}catch(ExistsProdutoException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse produto já estar cadastrado");
		}
	}
	
	@ResponseBody
	@GetMapping(value = "/listProdutos")
	public ResponseEntity<?> listar(){
		try {
			return ResponseEntity.ok(produtoService.list());
		}catch(ProdutoDoestExistsExcepiton e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe nenhum produto cadastrado na base de dados");
		}
	}
}
