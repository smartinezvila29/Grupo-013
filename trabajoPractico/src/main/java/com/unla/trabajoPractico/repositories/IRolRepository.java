package com.unla.trabajoPractico.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.trabajoPractico.entities.Rol;

@Repository("rolRepository")
public interface IRolRepository extends JpaRepository<Rol, Serializable>{
	
	public abstract Rol findByIdRol (int idRol);

}
