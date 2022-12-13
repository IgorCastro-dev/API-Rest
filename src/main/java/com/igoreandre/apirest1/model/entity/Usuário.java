package com.igoreandre.apirest1.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Usuário {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_usuario;
	
	private String login;
	
	private String email;
	
	private  String nome;
	
	private String afiliação;
	
	@OneToMany
	@JoinColumn(name = "id_atividade")
	private List<Atividade> atividades_favoritas;
	
	public Usuário() {};
	
	
	

	public long getId() {
		return id_usuario;
	}

	public void setId(long id) {
		this.id_usuario = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAfiliação() {
		return afiliação;
	}

	public void setAfiliação(String afiliação) {
		this.afiliação = afiliação;
	}




	public List<Atividade> getAtividades_favoritas() {
		return atividades_favoritas;
	}




	public void setAtividades_favoritas(Atividade atividades_favoritas) {
		this.atividades_favoritas.add(atividades_favoritas);
	}
}
