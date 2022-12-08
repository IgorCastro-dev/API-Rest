package com.igoreandre.apirest1.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
