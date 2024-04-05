package com.microservicios.creacionusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservicios.creacionusuarios.model.RegistroUsuarioModel;


public interface RegistroRepository extends JpaRepository<RegistroUsuarioModel, Integer>{
	@Query(value = "SELECT * FROM REGISTRO_USUARIO  WHERE TOKEN = ?1", nativeQuery = true)
	RegistroUsuarioModel validateToken(String token);
}
