package com.unla.trabajoPractico.helpers;

import javax.servlet.http.HttpSession;

public class SessionHelper {
	
	private HttpSession HttpSession = null;
	private String nombre = null;
	private String perfil = null;
	
	public SessionHelper(String nombre, String perfil) {
		super();
		this.nombre = nombre;
		this.perfil = perfil;
	}

	public HttpSession getHttpSession() {
		return HttpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		HttpSession = httpSession;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
