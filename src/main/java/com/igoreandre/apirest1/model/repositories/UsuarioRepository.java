package com.igoreandre.apirest1.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igoreandre.apirest1.model.entity.Usuário;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuário, Long>{

	

}
