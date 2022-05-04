package com.julianawl.dio.bankline.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianawl.dio.bankline.api.dto.NovaMovimentacao;
import com.julianawl.dio.bankline.api.model.Correntista;
import com.julianawl.dio.bankline.api.model.Movimentacao;
import com.julianawl.dio.bankline.api.model.MovimentacaoTipo;
import com.julianawl.dio.bankline.api.repository.CorrentistaRepository;
import com.julianawl.dio.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setValor(valor);
		movimentacao.setTipo(novaMovimentacao.getTipo());
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);
	}
}
