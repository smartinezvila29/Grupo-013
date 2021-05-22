package com.unla.trabajoPractico.entities;

import java.time.LocalDate;

public class Perfil {
	public int idPerfil;
	public int dni;
	public String nombre;
	public String apellido;
	public String email;
	public LocalDate fechaDeNacimiento;
	public String tipoPerfil;
	
	
	public Perfil() {}
	
	public Perfil(int dni, String nombre, String apellido, String email, LocalDate fechaDeNacimiento, String tipoPerfil) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipoPerfil = tipoPerfil;
	}

	
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

}