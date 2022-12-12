package com.igoreandre.apirest1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EspacoDTO {
	
	
	@NotNull
	private int capacidade;
	
	@NotBlank
	private String localizacao;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String recursos;
	
	
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRecursos() {
		return recursos;
	}
	
	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
	

}
