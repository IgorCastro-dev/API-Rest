package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.igoreandre.apirest1.model.entity.Atividade;
import com.igoreandre.apirest1.model.repositories.AtividadeRepository;

import jakarta.transaction.Transactional;

@Service
public class AtividadeService {
	@Autowired
	AtividadeRepository atividaderepository;
	
	@Transactional
	public Atividade salvar(Atividade atividade) {
		return atividaderepository.save(atividade);
	}
	
	@Transactional
	public Optional<Atividade> findById(long id) {
		return atividaderepository.findById(id);
	}

	public void deletaratividade(Atividade atividade) {
		atividaderepository.delete(atividade);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return atividaderepository.findAll();
	}

}
