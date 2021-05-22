package com.unla.trabajoPractico.entities;

import java.util.HashSet;
import java.util.Set;

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
	@OneToOne
	@JoinColumn(name = "idPerfil")
	private Perfil perfil;

	
	
	public Usuario() {}
	
	public Usuario(String nombre, String contraseña, Perfil perfil) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.perfil = perfil;
		this.active = true;
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
