package com.unla.trabajoPractico.entities;

public class Usuario {

	public int idUsuario;
	public String nombre;
	public String contraseña;
	public Perfil perfil;
	public boolean active;
	
	
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
