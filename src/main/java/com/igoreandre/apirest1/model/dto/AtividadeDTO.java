package com.igoreandre.apirest1.model.dto;

import java.sql.Time;
import java.util.Date;

import com.igoreandre.apirest1.model.Enum.TipoAtividade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AtividadeDTO {
	@NotBlank
	private String nome;
	@NotNull
	private TipoAtividade tipoatividade;
	@NotBlank
	private String descricao;
	@NotNull
	private Date data;
	@NotNull
	private Time hora_inicial;
	@NotNull
	private Time hora_final;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoAtividade getTipoatividade() {
		return tipoatividade;
	}
	public void setTipoatividade(TipoAtividade tipoatividade) {
		this.tipoatividade = tipoatividade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora_inicial() {
		return hora_inicial;
	}
	public void setHora_inicial(Time hora_inicial) {
		this.hora_inicial = hora_inicial;
	}
	public Time getHora_final() {
		return hora_final;
	}
	public void setHora_final(Time hora_final) {
		this.hora_final = hora_final;
	}
	
	
	
	
	
	
}
