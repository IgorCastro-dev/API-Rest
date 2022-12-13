package com.igoreandre.apirest1.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igoreandre.apirest1.model.entity.Atividade;
import com.igoreandre.apirest1.model.entity.Usuário;
import com.igoreandre.apirest1.model.services.AtividadeService;
import com.igoreandre.apirest1.model.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class FavoritarAtividadeController {
	
	@Autowired
	AtividadeService atividadeService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/favoritaratividade/{id_usuario}/{id_atividade}")
	public ResponseEntity<Object> cadastrarediçãot(@PathVariable(value = "id_atividade") long id_atividade,@PathVariable(value = "id_usuario") long id_usuario){
		Optional<Atividade> atividadeOptional = atividadeService.findById(id_atividade);
		if (!atividadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("atividade não encontrada");
		}
		Optional<Usuário> usuarioOptional = usuarioService.findById(id_atividade);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
		}
		
		Usuário usuario = usuarioOptional.get();
		Atividade atividade = atividadeOptional.get();
		
		
		atividade.setUsuario(usuario);
		Atividade atividadeSalva = atividadeService.salvar(atividade);
		
		usuario.setAtividades_favoritas(atividadeSalva);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
		
	}
}
