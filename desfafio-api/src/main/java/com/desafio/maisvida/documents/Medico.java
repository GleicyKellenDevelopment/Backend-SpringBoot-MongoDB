package com.desafio.maisvida.documents;



import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Medico {
	
	@Id
	private String id;
	
	@NotNull(message="O campo nome é obrigatório")
	private String nome; 
	
	@NotNull(message="O campo Último Nome é obrigatório")
	private String ultimo_nome;
	
	@NotNull(message="O campo Especialidade é obrigatório")
	private String especialidade;

	@NotNull(message="O campo Email é obrigatório")
	private String email;
	
	private Boolean is_ativo;
	
	private String status;
	
	private String uf;
	
	private String cidade;
	
	public Medico() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIs_ativo() {
		return is_ativo;
	}

	public void setIs_ativo(Boolean is_ativo) {
		this.is_ativo = is_ativo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
