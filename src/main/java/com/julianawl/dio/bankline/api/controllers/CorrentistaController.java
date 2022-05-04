package com.julianawl.dio.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.julianawl.dio.bankline.api.dto.NovoCorrentista;
import com.julianawl.dio.bankline.api.model.Correntista;
import com.julianawl.dio.bankline.api.repository.CorrentistaRepository;
import com.julianawl.dio.bankline.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
		
	}
	
	@PostMapping
	public void save( @RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}

}
