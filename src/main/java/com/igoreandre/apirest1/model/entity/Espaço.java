package com.igoreandre.apirest1.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Espaço {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_espaco;	
	
	private String nome;
	private String localizacao;
	private int capacidade;
	private String recursos;
	
	public Espaço() {}

	public long getId_espaco() {
		return id_espaco;
	}

	public void setId_espaco(long id_espaco) {
		this.id_espaco = id_espaco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	};
	
	
	
}
