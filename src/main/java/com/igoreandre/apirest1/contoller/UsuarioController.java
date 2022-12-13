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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioservice;
	
	@PostMapping("/cadastrarusuario")
	public ResponseEntity<Object> cadastrarusuario(@RequestBody @Valid UsuarioDTO usuariodto) {
		
		Usuário usuario = new Usuário();
		usuario.setNome(usuariodto.getNome());
		usuario.setLogin(usuariodto.getLogin());
		usuario.setEmail(usuariodto.getEmail());
		usuario.setAfiliação(usuariodto.getAfiliacao());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.salvar(usuario));
	}
	
	@DeleteMapping("/deletarusuario/{id}")
	public ResponseEntity<Object> deletarusuario(@PathVariable(value = "id") long id){
		Optional<Usuário> usuarioOptional = usuarioservice.findById(id);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
		}
		usuarioservice.deletarusuario(usuarioOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("usuario deletado com sucesso");
	}
	
	@PutMapping("/atualizausuario/{id}")
	public ResponseEntity<Object> atualizausuario(@PathVariable(value = "id") long id, @RequestBody @Valid UsuarioDTO usuariodto){
		Optional<Usuário> usuarioOptional = usuarioservice.findById(id);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("evento não encontrado");
		}
		Usuário usuario = usuarioOptional.get();
		
		usuario.setNome(usuariodto.getNome());
		usuario.setLogin(usuariodto.getLogin());
		usuario.setEmail(usuariodto.getEmail());
		usuario.setAfiliação(usuariodto.getAfiliacao());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.salvar(usuario));

	}
	
	@GetMapping("/mostrarusuario")
	public ResponseEntity<Object> mostrarusuario(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioservice.findAll());
	}
	
}
