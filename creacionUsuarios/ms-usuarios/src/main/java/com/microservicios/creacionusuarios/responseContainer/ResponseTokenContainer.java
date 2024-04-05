package com.microservicios.creacionusuarios.responseContainer;

import com.microservicios.creacionusuarios.response.MensajeResponse;

public class ResponseTokenContainer {
	
	 private MensajeResponse mensajeResponse;
	 
	public MensajeResponse getMensajeResponse() {
		 return mensajeResponse;
	}
	
	public void setMensajeResponse(MensajeResponse mensajeResponse) {
		this.mensajeResponse = mensajeResponse;
	}
	
}