package com.igoreandre.apirest1.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping("/deletarevento/{id}")
	public ResponseEntity<Object> deletarevento(@PathVariable(value = "id") long id){
		Optional<Evento> eventoOptional = eventoservice.findById(id);
		if (!eventoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("evento não encontrado");
		}
		eventoservice.deletarevento(eventoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("evento deletado com sucesso");
	}
	
	@PutMapping("/atualizaevento/{id}")
	public ResponseEntity<Object> atualizaevento(@PathVariable(value = "id") long id, @RequestBody @Valid EventoDTO eventodto){
		Optional<Evento> eventoOptional = eventoservice.findById(id);
		if (!eventoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("evento não encontrado");
		}
		Evento evento = eventoOptional.get();
		evento.setDescricao(eventodto.getDescrição());
		evento.setNome(eventodto.getNome());
		evento.setSigla(evento.getSigla());
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoservice.salvar(evento));

	}
	
	@GetMapping("/mostrarevento")
	public ResponseEntity<Object> mostrarevento(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.findAll());
	}
	
}
