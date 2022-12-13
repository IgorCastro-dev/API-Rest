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

import com.igoreandre.apirest1.model.dto.UsuarioDTO;
import com.igoreandre.apirest1.model.entity.Usuário;
import com.igoreandre.apirest1.model.services.UsuarioService;

import jakarta.validation.Valid;

@RestController

//@PathVariable

@RequestMapping("/usuario")

public class VisualizarEventoController {
	
	@Autowired
	UsuarioService usuarioservice;
	
	
	
	@GetMapping("/{caminho_evento}/{ano_edicao}")
	public ResponseEntity<Object> mostrarusuario(@PathVariable(value = "caminho_evento") String caminho_evento,
												 @PathVariable(value = "ano_edicao") int ano_edicao){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioservice.findEvento(caminho_evento,ano_edicao));
	}
	
}
