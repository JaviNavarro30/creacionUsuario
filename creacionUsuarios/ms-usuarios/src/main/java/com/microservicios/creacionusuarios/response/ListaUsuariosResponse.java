package com.microservicios.creacionusuarios.response;

import java.util.List;

import com.microservicios.creacionusuarios.model.UsuarioModel;


public class ListaUsuariosResponse {
	
	private List<UsuarioModel> listaUsuarios;
	
	
	public ListaUsuariosResponse() {
		
	}
	public ListaUsuariosResponse(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<UsuarioModel> getUsuarios() {
		return listaUsuarios;
	}
	public void setUsuarios(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
