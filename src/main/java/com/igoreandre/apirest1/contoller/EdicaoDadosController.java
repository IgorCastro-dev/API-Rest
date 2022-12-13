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
@RequestMapping("/organizador")
public class EdicaoDadosController {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	EdicaoService edicaoService;

	@PutMapping("/atualizardadosedicao/chamada_trabalho/{id_edicao}")
	public ResponseEntity<Object> atualizar_chamada_trabalho(@PathVariable(name = "id_edicao") long id_edicao,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		
		Edição edicao = edicaoOptional.get();
		edicao.setChamada_trabalho(edicaodto.getChamada_trabalho());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoService.salvar(edicao));
		
	}
	
	@PutMapping("/atualizardadosedicao/prazos/{id_edicao}")
	public ResponseEntity<Object> atualizar_prazos(@PathVariable(name = "id_edicao") long id_edicao,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		
		Edição edicao = edicaoOptional.get();
		edicao.setPrazo(edicaodto.getPrazo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoService.salvar(edicao));
		
	}
	
	@PutMapping("/atualizardadosedicao/inscricoes/{id_edicao}")
	public ResponseEntity<Object> atualizar_inscricoes(@PathVariable(name = "id_edicao") long id_edicao,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		
		Edição edicao = edicaoOptional.get();
		edicao.setInscricoes(edicaodto.getInscricoes());

		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoService.salvar(edicao));
		
	}
	
	@PutMapping("/atualizardadosedicao/lista_organizadores/{id_edicao}")
	public ResponseEntity<Object> atualizar_lista_organizadores(@PathVariable(name = "id_edicao") long id_edicao,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Edição> edicaoOptional = edicaoService.findById(id_edicao);
		if (!edicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("edição não encontrada");
		}
		
		Edição edicao = edicaoOptional.get();
		edicao.setLista_organizadores(edicaodto.getLista_organizadores());

		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoService.salvar(edicao));
		
	}
	
	
	
	
	@GetMapping("/mostrardadosedicao")
	public ResponseEntity<Object> mostraredicao(){
		return ResponseEntity.status(HttpStatus.OK).body(edicaoService.findAll());
	}

}
