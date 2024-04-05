package com.microservicios.creacionusuarios.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_usuario")
    private String idUsuario;
	@Column(name="name", nullable= false)
    private String name;
	@Column(name="email", nullable = false)
    private String email;
	@Column(name="password", nullable = false)
    private String password;
     
    @OneToMany(cascade = CascadeType.ALL)
    private List<PhonesModel> phonesModel;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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

	private static final long serialVersionUID = -2451286255013673023L;
}
