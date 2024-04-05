package com.microservicios.creacionusuarios.responseContainer;

import com.microservicios.creacionusuarios.response.MensajeResponse;
import com.microservicios.creacionusuarios.response.RegistroUsuarioResponse;

public class ResponseRegistroContainer {
	
	
    private MensajeResponse mensajeResponse;
    private RegistroUsuarioResponse registroUsuarioResponse;
    
	
	public MensajeResponse getMensajeResponse() {
		return mensajeResponse;
	}
	public void setMensajeResponse(MensajeResponse mensajeResponse) {
		this.mensajeResponse = mensajeResponse;
	}
	
	public RegistroUsuarioResponse getRegistroUsuarioResponse() {
		return registroUsuarioResponse;
	}
	public void setRegistroUsuarioResponse(RegistroUsuarioResponse registroUsuarioResponse) {
		this.registroUsuarioResponse = registroUsuarioResponse;
	}
	  
}