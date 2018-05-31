package com.desafio.maisvida.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.maisvida.documents.Medico;
import com.desafio.maisvida.responses.Response;
import com.desafio.maisvida.services.MedicoService;

@RestController
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@CrossOrigin 
	@GetMapping("listarmedicos")
	public ResponseEntity<Response<List<Medico>>> listarMedicos() {
		return ResponseEntity.ok(new Response<List<Medico>>(this.medicoService.listarTodos()));
	}
	
	@CrossOrigin 
	@GetMapping("listarmedicos/{id}")
	public ResponseEntity<Response<Medico>> listarPorId(@PathVariable(name="id") String id) {
		return ResponseEntity.ok(new Response<Medico>(this.medicoService.listarPorId(id)));
	}
	
	@CrossOrigin 
	@PostMapping("cadastrarmedicos")
	public ResponseEntity<Response<Medico>> cadastrar(@Valid @RequestBody Medico medico, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
			return ResponseEntity.ok().body(new Response<Medico>(errors));
		}
		
		return ResponseEntity.ok( new Response<Medico>(medicoService.cadastrar(medico)));
	}
	
	@PutMapping("medicos/{id}")
	public ResponseEntity<Response<Medico>> atualizar (@PathVariable(name ="id") String id, @Valid @RequestBody Medico medico, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Medico>(errors));
		}
		
		medico.setId(id);
		return ResponseEntity.ok(new Response<Medico>(this.medicoService.atualizar(medico)));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name="id") String id) {
		this.medicoService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
	
	
	
}
