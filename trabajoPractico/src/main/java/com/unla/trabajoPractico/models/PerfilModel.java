package com.unla.trabajoPractico.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PerfilModel {
	
	private int idPerfil;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private long nroDocumento;
	private String email;
	
	public PerfilModel() {}

	public PerfilModel(int idPerfil, String nombre, String apellido, String tipoDocumento, long nroDocumento,
			String email) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.email = email;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
