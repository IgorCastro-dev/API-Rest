package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.igoreandre.apirest1.model.entity.Evento;
import com.igoreandre.apirest1.model.repositories.EventoRepository;

import jakarta.transaction.Transactional;

@Service
public class EventoService {
	@Autowired
	EventoRepository eventorepository;
	
	@Transactional
	public Evento salvar(Evento evento) {
		return eventorepository.save(evento);
	}
	
	@Transactional
	public Optional<Evento> findById(long id) {
		return eventorepository.findById(id);
	}

	public void deletarevento(Evento evento) {
		eventorepository.delete(evento);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return eventorepository.findAll();
	}

	public Object findEvento(String caminho_evento,int ano) {
		return eventorepository.findEvento(caminho_evento,ano);
	}

}
