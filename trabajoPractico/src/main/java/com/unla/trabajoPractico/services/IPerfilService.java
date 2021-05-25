package com.unla.trabajoPractico.services;

import java.util.List;

import com.unla.trabajoPractico.entities.Perfil;
import com.unla.trabajoPractico.models.PerfilModel;

public interface IPerfilService {
	
	public List<Perfil> getAll();
	public PerfilModel insert(PerfilModel perfilModel);
	public boolean remove(int id);
	public PerfilModel findById(int id);
	PerfilModel update(PerfilModel perfilModel);

}
