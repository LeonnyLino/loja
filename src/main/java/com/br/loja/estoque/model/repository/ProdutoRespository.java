package com.br.loja.estoque.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.loja.estoque.model.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Long> {

}
