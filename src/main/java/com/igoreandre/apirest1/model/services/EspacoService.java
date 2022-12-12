package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.igoreandre.apirest1.model.entity.Espaço;
import com.igoreandre.apirest1.model.repositories.EspacoRepository;

import jakarta.transaction.Transactional;

@Service
public class EspacoService {
	@Autowired
	EspacoRepository espacorepository;
	
	@Transactional
	public Espaço salvar(Espaço espaco) {
		return espacorepository.save(espaco);
	}
	
	@Transactional
	public Optional<Espaço> findById(long id) {
		return espacorepository.findById(id);
	}

	public void deletarespaco(Espaço espaco) {
		espacorepository.delete(espaco);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return espacorepository.findAll();
	}

}
