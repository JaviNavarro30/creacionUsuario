package com.microservicios.creacionusuarios.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "registro_usuario")
public class RegistroUsuarioModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reg_usuario")
	private int idRegUsuario;
	
	@Column(name="id", length = 255)
	private String id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USUARIO", referencedColumnName = "id_usuario")
	private UsuarioModel fkUsuario;
	
	@Column(name= "created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column(name= "modified", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	@Column(name= "last_login", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_login;
	
	@Column(name= "token", nullable = true)
	private String token;
	
	@Column(name= "isactive")
	private boolean isactive;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public UsuarioModel getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(UsuarioModel fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
		
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public int getIdRegUsuario() {
		return idRegUsuario;
	}
	public void setIdRegUsuario(int idRegUsuario) {
		this.idRegUsuario = idRegUsuario;
	}
	
}