package com.julianawl.dio.bankline.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianawl.dio.bankline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

	public List<Movimentacao>findByIdConta(Integer idConta);
}
