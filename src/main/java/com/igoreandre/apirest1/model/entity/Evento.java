package com.igoreandre.apirest1.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_evento;
	
	private String nome;
	private String sigla;
	private String descricao;
	private String caminho;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_evento")
	private Edição edicao;
	
	public Evento() {}

	public long getId_evento() {
		return id_evento;
	}

	public void setId_evento(long id_evento) {
		this.id_evento = id_evento;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Edição getEdicao() {
		return edicao;
	}

	public void setEdicao(Edição edicao) {
		this.edicao = edicao;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	
	
	
}
