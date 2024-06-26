package com.microservicios.creacionusuarios.response;


public class RegistroUsuarioResponse{
	
	 private String id;
	 private String created;
	 private String modified;
	 private String lastLogin;
	 private String token;
	 private boolean isActive;
 
	public RegistroUsuarioResponse() {
		
	}

	public RegistroUsuarioResponse(String id, String created, String modified, String lastLogin, String token,
			boolean isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCreated() {
		return created;
	}



	public void setCreated(String created) {
		this.created = created;
	}



	public String getModified() {
		return modified;
	}



	public void setModified(String modified) {
		this.modified = modified;
	}



	public String getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	  
}
