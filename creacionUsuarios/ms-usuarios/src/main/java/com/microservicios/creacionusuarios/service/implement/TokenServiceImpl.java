package com.microservicios.creacionusuarios.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.creacionusuarios.model.RegistroUsuarioModel;
import com.microservicios.creacionusuarios.repository.RegistroRepository;
import com.microservicios.creacionusuarios.response.MensajeResponse;
import com.microservicios.creacionusuarios.responseContainer.ResponseTokenContainer;
import com.microservicios.creacionusuarios.service.ITokenService;

@Service
public class TokenServiceImpl implements ITokenService{
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Override
	public ResponseTokenContainer validarToken(String token) {
		
		RegistroUsuarioModel registroUsuario = new RegistroUsuarioModel();
		MensajeResponse mensaje = new MensajeResponse();
		
		ResponseTokenContainer responseTokenContainer = new ResponseTokenContainer();
		
		registroUsuario = registroRepository.validateToken(token);
		
		try {
			
			if (registroUsuario.isIsactive() == false) {
				
				mensaje.setCodigo(400);
				mensaje.setMensaje("Token expirado o inexistente");			
				responseTokenContainer.setMensajeResponse(mensaje);
				
			} else {
				mensaje.setCodigo(200);
				mensaje.setMensaje("Token activo");
	
				responseTokenContainer.setMensajeResponse(mensaje);
			}

		} catch (Exception e) {
			mensaje.setCodigo(404);
			mensaje.setMensaje("Token inexistente");
			responseTokenContainer.setMensajeResponse(mensaje);
		}
		
		return responseTokenContainer;

	}

}
