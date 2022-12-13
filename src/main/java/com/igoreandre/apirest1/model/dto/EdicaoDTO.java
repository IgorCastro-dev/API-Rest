package com.igoreandre.apirest1.model.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EdicaoDTO{ 
	@NotNull
	private int numero;

	@NotNull
	private int ano;
	
	@NotNull
	private Date data_inicial;
	
	@NotNull
	private Date data_final;
	
	@NotBlank
	private String cidade;
	
	private String chamada_trabalho;
	
	private Date prazo;
	
	private String inscricoes;

	private String lista_organizadores;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getChamada_trabalho() {
		return chamada_trabalho;
	}
	public void setChamada_trabalho(String chamada_trabalho) {
		this.chamada_trabalho = chamada_trabalho;
	}
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	public String getInscricoes() {
		return inscricoes;
	}
	public void setInscricoes(String incricoes) {
		this.inscricoes = incricoes;
	}
	public String getLista_organizadores() {
		return lista_organizadores;
	}
	public void setLista_organizadores(String lista_organizadores) {
		this.lista_organizadores = lista_organizadores;
	}
	
	
}
