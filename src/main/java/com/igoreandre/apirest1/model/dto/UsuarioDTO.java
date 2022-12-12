package com.igoreandre.apirest1.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private String login;
	@NotBlank
	private String email;
	@NotBlank
	private String afiliacao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getAfiliacao() {
		return afiliacao;
	}
	public void setAfiliacao(String afiliacao) {
		this.afiliacao = afiliacao;
	}
	
	
	
	
}
