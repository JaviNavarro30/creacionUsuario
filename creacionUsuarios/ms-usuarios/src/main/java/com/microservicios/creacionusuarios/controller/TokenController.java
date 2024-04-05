package com.microservicios.creacionusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.creacionusuarios.responseContainer.ResponseTokenContainer;
import com.microservicios.creacionusuarios.service.ITokenService;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private ITokenService iTokenService;
	
	@GetMapping("/validarToken")
	public ResponseTokenContainer validarToken(@RequestHeader("token") String token) {
		return iTokenService.validarToken(token);
	}

}
