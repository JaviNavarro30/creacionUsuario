package com.microservicios.creacionusuarios.service;

import com.microservicios.creacionusuarios.request.RegistroUsuarioRequest;
import com.microservicios.creacionusuarios.responseContainer.ResponseListaUsuariosContainer;
import com.microservicios.creacionusuarios.responseContainer.ResponseRegistroContainer;

public interface IRegistroUsuarioService {
	public ResponseRegistroContainer registrarUsuario(RegistroUsuarioRequest Req);
	public ResponseListaUsuariosContainer obtenerUsuarios(String token);
}
