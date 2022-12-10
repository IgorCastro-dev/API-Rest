package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igoreandre.apirest1.model.entity.Edição;
import com.igoreandre.apirest1.model.repositories.EdicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class EdicaoService {

	@Autowired
	EdicaoRepository edicaoRepository;
	
	@Transactional
	public Edição salvar(Edição edicao) {
		return edicaoRepository.save(edicao);
		
	}
}
