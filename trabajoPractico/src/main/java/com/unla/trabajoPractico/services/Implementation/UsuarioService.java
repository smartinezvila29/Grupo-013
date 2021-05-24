package com.unla.trabajoPractico.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.trabajoPractico.converters.UsuarioConverter;
import com.unla.trabajoPractico.entities.Usuario;
import com.unla.trabajoPractico.models.UsuarioModel;
import com.unla.trabajoPractico.repositories.IUsuarioRepository;
import com.unla.trabajoPractico.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository; 
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		Usuario usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
		return usuarioConverter.entityToModel(usuario);
	}
	
	
	

}
