package com.unla.trabajoPractico.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.trabajoPractico.entities.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{
	
	public abstract Perfil findByNroDocumento(long nroDocumento);
	public abstract Perfil findByNombreAndApellido(String nombre, String apellido);
	public abstract Perfil findByEmail(String email);

}
