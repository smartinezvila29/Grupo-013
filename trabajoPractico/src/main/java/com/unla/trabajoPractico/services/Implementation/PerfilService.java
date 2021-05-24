package com.unla.trabajoPractico.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.trabajoPractico.converters.PerfilConverter;
import com.unla.trabajoPractico.entities.Perfil;
import com.unla.trabajoPractico.models.PerfilModel;
import com.unla.trabajoPractico.repositories.IPerfilRepository;
import com.unla.trabajoPractico.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService {
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Override
	public List<Perfil> getAll() {
		return perfilRepository.findAll();
	}
	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		Perfil perfil = perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
		return perfilConverter.entityToModel(perfil);
	}
	
	
	

}
