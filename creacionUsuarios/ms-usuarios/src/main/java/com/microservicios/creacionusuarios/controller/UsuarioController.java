package com.microservicios.creacionusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.creacionusuarios.request.RegistroUsuarioRequest;
import com.microservicios.creacionusuarios.responseContainer.ResponseListaUsuariosContainer;
import com.microservicios.creacionusuarios.responseContainer.ResponseRegistroContainer;
import com.microservicios.creacionusuarios.service.IRegistroUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
		@Autowired
		private IRegistroUsuarioService iUsuarioService;

	    @PostMapping("/registroUsuario")
		public ResponseRegistroContainer registroUsuario(@RequestBody RegistroUsuarioRequest request) {
			return iUsuarioService.registrarUsuario(request);
		}
	    
	    @GetMapping("/obtenerUsuarios")
		public ResponseListaUsuariosContainer obtenerUsuarios(@RequestHeader("token") String token){
			return iUsuarioService.obtenerUsuarios(token);
		}
	    
}