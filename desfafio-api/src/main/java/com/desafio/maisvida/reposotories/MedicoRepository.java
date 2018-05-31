package com.desafio.maisvida.reposotories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafio.maisvida.documents.Medico;

public interface MedicoRepository extends MongoRepository<Medico, String> {

}
