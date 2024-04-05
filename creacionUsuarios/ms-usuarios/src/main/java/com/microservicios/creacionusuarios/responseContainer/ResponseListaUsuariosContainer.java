package com.microservicios.creacionusuarios.responseContainer;

import com.microservicios.creacionusuarios.response.ListaUsuariosResponse;
import com.microservicios.creacionusuarios.response.MensajeResponse;

public class ResponseListaUsuariosContainer {
	
	private MensajeResponse mensajeResponse;
    private ListaUsuariosResponse listaUsuariosResponse;
    
    public MensajeResponse getMensajeResponse() {
		return mensajeResponse;
	}
	public void setMensajeResponse(MensajeResponse mensajeResponse) {
		this.mensajeResponse = mensajeResponse;
	}
	
	public ListaUsuariosResponse getListaUsuariosResponse() {
		return listaUsuariosResponse;
	}
	public void setListaUsuariosResponse(ListaUsuariosResponse listaUsuariosResponse) {
		this.listaUsuariosResponse = listaUsuariosResponse;
	}
}
