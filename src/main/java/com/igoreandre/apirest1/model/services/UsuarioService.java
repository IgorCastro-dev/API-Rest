package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.igoreandre.apirest1.model.entity.Usuário;
import com.igoreandre.apirest1.model.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuariorepository;
	
	@Transactional
	public Usuário salvar(Usuário usuario) {
		return usuariorepository.save(usuario);
	}
	
	@Transactional
	public Optional<Usuário> findById(long id) {
		return usuariorepository.findById(id);
	}

	public void deletarusuario(Usuário usuario) {
		usuariorepository.delete(usuario);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return usuariorepository.findAll();
	}

	public Object findEvento(String caminho_evento, int ano_edicao) {
		// TODO Auto-generated method stub
		
		
		return usuariorepository.findEvento(caminho_evento,ano_edicao);
	}

}
