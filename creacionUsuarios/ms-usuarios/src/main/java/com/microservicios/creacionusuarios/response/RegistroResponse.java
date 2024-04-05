package com.microservicios.creacionusuarios.response;

public class RegistroResponse {
	
	private RegistroUsuarioResponse registroUsuarioResponse;
	
	private MensajeResponse mensaje;
	
	public RegistroResponse() {
		
	}
	public RegistroResponse(RegistroUsuarioResponse registroUsuarioResponse, MensajeResponse mensaje) {
		this.registroUsuarioResponse = registroUsuarioResponse;
		this.mensaje = mensaje;
	}

	public RegistroUsuarioResponse getRegistroUsuarioResponse() {
		return registroUsuarioResponse;
	}

	public void setRegistroUsuarioResponse(RegistroUsuarioResponse registroUsuarioResponse) {
		this.registroUsuarioResponse = registroUsuarioResponse;
	}

	public MensajeResponse getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeResponse mensaje) {
		this.mensaje = mensaje;
	}
	
	
	

}
