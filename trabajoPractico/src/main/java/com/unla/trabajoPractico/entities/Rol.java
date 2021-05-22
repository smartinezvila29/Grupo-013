package com.unla.trabajoPractico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="rol", uniqueConstraints = @UniqueConstraint(columnNames = {"rol", "idUsuario"}))
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	@Column(name = "rol", nullable = false, length = 100)
	private String rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	public Rol(int idRol, String rol, Usuario usuario) {
		super();
		this.idRol = idRol;
		this.rol = rol;
		this.usuario = usuario;
	}

	public int getId() {
		return idRol;
	}

	public void setId(int id) {
		this.idRol = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
