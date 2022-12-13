package com.igoreandre.apirest1.model.entity;

import java.sql.Time;
import java.util.Date;

import com.igoreandre.apirest1.model.Enum.TipoAtividade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_atividade;
	
	private String nome;
	private TipoAtividade tipoatividade;
	private String descricao;
	private Date data;
	private Time hora_inicial;
	private Time hora_final;
	
	@ManyToOne
	@JoinColumn(name = "id_edicao")
	private Edição edicao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuário usuario;
	
	public Usuário getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuário usuario) {
		this.usuario = usuario;
	}

	public Atividade() {}

	public long getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(long id_atividade) {
		this.id_atividade = id_atividade;
	}

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

	public Edição getEdicao() {
		return edicao;
	}

	public void setEdicao(Edição edicao) {
		this.edicao = edicao;
	};
	
	
}
