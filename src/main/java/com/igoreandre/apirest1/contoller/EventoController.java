package com.igoreandre.apirest1.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igoreandre.apirest1.model.dto.EventoDTO;
import com.igoreandre.apirest1.model.entity.Evento;
import com.igoreandre.apirest1.model.services.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/administrador")
public class EventoController {
	
	@Autowired
	EventoService eventoservice;
	
	@PostMapping("/cadastrarevento")
	public ResponseEntity<Object> cadastrarevento(@RequestBody @Valid EventoDTO eventodto) {
		Evento evento = new Evento();
		evento.setDescricao(eventodto.getDescrição());
		evento.setNome(eventodto.getNome());
		evento.setSigla(eventodto.getSigla());
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoservice.salvar(evento));
	}
}
