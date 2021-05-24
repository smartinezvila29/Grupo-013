package com.unla.trabajoPractico.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name=("usuario"))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(name=("nombre"))
	private String nombre;
	@Column(name=("contraseña"))
	private String contraseña;
	@Column(name=("active"))
	private boolean active;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Rol> rol = new HashSet<Rol>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPerfil", unique = true)
	private Perfil perfil;
	
	public Usuario() {
		this.perfil = new Perfil();
	}

	public Usuario(int idUsuario, String nombre, String contraseña, boolean active) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.active = active;
	}

	public Usuario(String nombre, String contraseña, boolean active, Set<Rol> rol, Perfil perfil) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.active = active;
		this.rol = rol;
		this.perfil = perfil;
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
