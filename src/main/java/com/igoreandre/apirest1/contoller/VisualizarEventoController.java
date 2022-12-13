package com.igoreandre.apirest1.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igoreandre.apirest1.model.services.EventoService;

@RestController

//@PathVariable

@RequestMapping("/usuario")

public class VisualizarEventoController {
	
	@Autowired
	EventoService eventoService;
	
	
	
	@GetMapping("/{caminho_evento}/{ano_edicao}")
	public ResponseEntity<Object> mostrarusuario(@PathVariable(value = "caminho_evento") String caminho_evento,
												 @PathVariable(value = "ano_edicao") int ano_edicao){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.findEvento(caminho_evento,ano_edicao));
	}
	
}
