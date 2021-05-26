package com.unla.trabajoPractico.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.trabajoPractico.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findByNombre(String nombre);
	public abstract Usuario findByIdUsuario (int idUsuario);

}
