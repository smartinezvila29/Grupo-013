package com.unla.trabajoPractico.converters;

import org.springframework.stereotype.Component;

import com.unla.trabajoPractico.entities.Perfil;
import com.unla.trabajoPractico.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {
	
	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(), perfil.getNombre(), perfil.getApellido(), perfil.getTipoDocumento(), perfil.getNroDocumento(), perfil.getEmail());
	}
	
	public Perfil modelToEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(), perfilModel.getNombre(), perfilModel.getApellido(), perfilModel.getTipoDocumento(), perfilModel.getNroDocumento(), perfilModel.getEmail());
	}

}
