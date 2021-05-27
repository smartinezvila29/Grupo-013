package com.unla.trabajoPractico.services;

import java.util.List;

import com.unla.trabajoPractico.entities.Usuario;
import com.unla.trabajoPractico.models.UsuarioModel;

public interface IUsuarioService {
	
	public List<Usuario> getAll();
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	public boolean delete(int idUsuario);
	public UsuarioModel getUser(String nombre);
	public UsuarioModel update(UsuarioModel usuarioModel);
}
