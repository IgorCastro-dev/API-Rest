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

import com.igoreandre.apirest1.model.dto.EdicaoDTO;
import com.igoreandre.apirest1.model.entity.Edição;
import com.igoreandre.apirest1.model.entity.Evento;
import com.igoreandre.apirest1.model.services.EdicaoService;
import com.igoreandre.apirest1.model.services.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/administrador")
public class EdicaoController {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	EdicaoService edicaoService;
	
	
	@PostMapping("/cadastraredicao/{id_evento}")
	public ResponseEntity<Object> cadastrarediçãot(@PathVariable(value = "id_evento") long id_evento,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Evento> eventoOptional = eventoService.findById(id_evento);
		if (!eventoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("evento não encontrado");
		}
		Evento evento = eventoOptional.get();
		
		Edição edicao = new Edição();
		edicao.setAno(edicaodto.getAno());
		edicao.setCidade(edicaodto.getCidade());
		edicao.setData_final(edicaodto.getData_final());
		edicao.setData_inicial(edicaodto.getData_inicial());
		edicao.setNumero(edicaodto.getNumero());
		
		Edição ediçãoSalva = edicaoService.salvar(edicao);
		evento.setEdicao(ediçãoSalva);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.salvar(evento));
		
	}
	
	@PutMapping("/atualizaredicao/{id_edicao}")
	public ResponseEntity<Object> atualizaedicao(@PathVariable(name = "id_edicao") long id_edicao,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		
		Edição edicao = edicaoOptional.get();
		edicao.setAno(edicaodto.getAno());
		edicao.setCidade(edicaodto.getCidade());
		edicao.setData_final(edicaodto.getData_final());
		edicao.setData_inicial(edicaodto.getData_inicial());
		edicao.setNumero(edicaodto.getNumero());
		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoService.salvar(edicao));
		
	}
	
	
	@DeleteMapping("/deletaredicao/{id_edicao}")
	public ResponseEntity<Object> deletaredicao(@PathVariable(name = "id_edicao") long id_edicao) {
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		edicaoService.deletar(id_edicao);
		return ResponseEntity.status(HttpStatus.OK).body("edição deletada");
	}
	
	@GetMapping("/mostraredicao")
	public ResponseEntity<Object> mostraredicao(){
		return ResponseEntity.status(HttpStatus.OK).body(edicaoService.findAll());
	}

}
