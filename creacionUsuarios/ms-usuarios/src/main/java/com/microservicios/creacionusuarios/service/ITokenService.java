package com.microservicios.creacionusuarios.service;

import com.microservicios.creacionusuarios.responseContainer.ResponseTokenContainer;

public interface ITokenService {
	
	public ResponseTokenContainer validarToken(String token);

}
