package com.microservicios.creacionusuarios.response;

public class TokenResponse {
	
	private String estado;
	private MensajeResponse mensaje;

	public TokenResponse() {
		
	}
	
	public TokenResponse(String estado, MensajeResponse mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public MensajeResponse getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeResponse mensaje) {
		this.mensaje = mensaje;
	}

}
