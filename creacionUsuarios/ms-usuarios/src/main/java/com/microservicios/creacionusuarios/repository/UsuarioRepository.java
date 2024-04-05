package com.microservicios.creacionusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservicios.creacionusuarios.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
	@Query(value = "SELECT count(email) FROM USUARIOS WHERE EMAIL = ?1 ", nativeQuery = true)
	int emailsRepetidos(String email);
}