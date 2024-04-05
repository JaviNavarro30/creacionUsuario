package com.microservicios.creacionusuarios.request;

import java.util.List;

import com.microservicios.creacionusuarios.model.PhonesModel;

public class RegistroUsuarioRequest {

    private String name;
    private String email;
    private String password;
    private List<PhonesModel> phonesModel;
    
	public RegistroUsuarioRequest(String name, String email, String password, List<PhonesModel> phonesModel) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonesModel = phonesModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhonesModel> getPhones() {
		return phonesModel;
	}

	public void setPhones(List<PhonesModel> phonesModel) {
		this.phonesModel = phonesModel;
	}
	
	
}
