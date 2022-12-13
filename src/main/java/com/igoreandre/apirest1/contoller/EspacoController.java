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

import com.igoreandre.apirest1.model.dto.EspacoDTO;
import com.igoreandre.apirest1.model.entity.Espaço;
import com.igoreandre.apirest1.model.services.EspacoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/organizador")
public class EspacoController {
	
	@Autowired
	EspacoService espacoservice;
	
	@PostMapping("/cadastrarespaco")
	public ResponseEntity<Object> cadastrarespaco(@RequestBody @Valid EspacoDTO espacodto) {
		Espaço espaco = new Espaço();
		
		espaco.setCapacidade(espacodto.getCapacidade());
		espaco.setLocalizacao(espacodto.getLocalizacao());
		espaco.setRecursos(espacodto.getRecursos());
		espaco.setNome(espacodto.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(espacoservice.salvar(espaco));
	}
	
	@DeleteMapping("/deletarespaco/{id}")
	public ResponseEntity<Object> deletarespaco(@PathVariable(value = "id") long id){
		Optional<Espaço> espacoOptional = espacoservice.findById(id);
		if (!espacoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("espaço não encontrado");
		}
		espacoservice.deletarespaco(espacoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("espaço deletado com sucesso");
	}
	
	@PutMapping("/atualizaespaco/{id}")
	public ResponseEntity<Object> atualizaespaco(@PathVariable(value = "id") long id, @RequestBody @Valid EspacoDTO espacodto){
		Optional<Espaço> espacoOptional = espacoservice.findById(id);
		if (!espacoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("espaço não encontrado");
		}
		Espaço espaco = espacoOptional.get();
		espaco.setCapacidade(espacodto.getCapacidade());
		espaco.setLocalizacao(espacodto.getLocalizacao());
		espaco.setRecursos(espacodto.getRecursos());
		espaco.setNome(espacodto.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(espacoservice.salvar(espaco));

	}
	
	@GetMapping("/mostrarespaco")
	public ResponseEntity<Object> mostrarespaco(){
		return ResponseEntity.status(HttpStatus.OK).body(espacoservice.findAll());
	}
	
}
