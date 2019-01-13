package com.br.loja.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.loja.estoque.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
