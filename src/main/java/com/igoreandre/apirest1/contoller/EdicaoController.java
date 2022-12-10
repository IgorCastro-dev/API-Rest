package com.igoreandre.apirest1.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/cadastraredicao/{id}")
	public ResponseEntity<Object> cadastrarediçãot(@PathVariable(value = "id") long id,@RequestBody @Valid EdicaoDTO edicaodto){
		Optional<Evento> eventoOptional = eventoService.findById(id);
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
}
