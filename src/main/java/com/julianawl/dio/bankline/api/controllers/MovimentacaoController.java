package com.julianawl.dio.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.julianawl.dio.bankline.api.dto.NovaMovimentacao;
import com.julianawl.dio.bankline.api.dto.NovoCorrentista;
import com.julianawl.dio.bankline.api.model.Correntista;
import com.julianawl.dio.bankline.api.model.Movimentacao;
import com.julianawl.dio.bankline.api.repository.CorrentistaRepository;
import com.julianawl.dio.bankline.api.repository.MovimentacaoRepository;
import com.julianawl.dio.bankline.api.services.CorrentistaService;
import com.julianawl.dio.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
		
	}
	
	@PostMapping
	public void save( @RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}

	@GetMapping("/{idConta}")
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return repository.findByIdConta(idConta);
	}
}
