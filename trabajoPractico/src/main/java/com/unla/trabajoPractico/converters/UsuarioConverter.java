package com.unla.trabajoPractico.converters;

import org.springframework.stereotype.Component;

import com.unla.trabajoPractico.entities.Usuario;
import com.unla.trabajoPractico.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(), usuario.getNombre(), usuario.getContraseña(), usuario.isActive());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getIdUsuario(), usuarioModel.getNombre(), usuarioModel.getContraseña(), usuarioModel.isActive());
	}

}
