package com.unla.trabajoPractico.services;

import java.util.List;

import com.unla.trabajoPractico.entities.Rodado;
import com.unla.trabajoPractico.models.RodadoModel;

public interface IRodadoService {
	
	public List<Rodado> getAll();
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel);
	public boolean remove(int id);
	public RodadoModel findById(int id);

}
