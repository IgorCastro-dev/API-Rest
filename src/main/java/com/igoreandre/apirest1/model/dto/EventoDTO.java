package com.igoreandre.apirest1.model.dto;

import jakarta.validation.constraints.NotBlank;

public class EventoDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private String sigla;
	@NotBlank
	private String descrição;
	@NotBlank
	private String caminho;
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
