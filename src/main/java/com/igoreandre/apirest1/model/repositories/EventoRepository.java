package com.igoreandre.apirest1.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.igoreandre.apirest1.model.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	
	@Query(value = "SELECT E from Evento as E where E.caminho = ?1")
	Object findEvento(String caminho_evento,int ano);

}
