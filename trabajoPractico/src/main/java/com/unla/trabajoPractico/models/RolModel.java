package com.unla.trabajoPractico.models;

public class RolModel {
	
	private int idRol;
	private String rol;
	
	public RolModel(int idRol, String rol) {
		super();
		this.idRol = idRol;
		this.rol = rol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	

}
