package com.desafio.maisvida.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.maisvida.documents.Medico;
import com.desafio.maisvida.reposotories.MedicoRepository;
import com.desafio.maisvida.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public List<Medico> listarTodos() {
		return this.medicoRepository.findAll();
	}
	
	@Override
	public Medico cadastrar(Medico medico) {
		return this.medicoRepository.save(medico);
	}

	@Override
	public Medico atualizar(Medico medico) {
		return this.medicoRepository.save(medico);
	}

	@Override
	public Medico listarPorId(String id) {
		return this.medicoRepository.findOne(id);
	}

	@Override
	public void remover(String id) {
		 this.medicoRepository.delete(id);
	}

}
