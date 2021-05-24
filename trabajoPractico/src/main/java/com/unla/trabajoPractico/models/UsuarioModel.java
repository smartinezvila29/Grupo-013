package com.unla.trabajoPractico.models;

public class UsuarioModel {
	
	private int idUsuario;
	private String nombre;
	private String contraseña;
	private boolean active;
	
	public UsuarioModel() {}

	public UsuarioModel(int idUsuario, String nombre, String contraseña, boolean active) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
