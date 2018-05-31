package com.desafio.maisvida.services;

import java.util.List;

import com.desafio.maisvida.documents.Medico;

public interface MedicoService {
	
	List<Medico> listarTodos();
	
	Medico listarPorId(String id);
	
	Medico cadastrar(Medico medico);
	
	Medico atualizar(Medico medico);
	
	void remover(String id); 
	
}
