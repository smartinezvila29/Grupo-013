package com.unla.trabajoPractico.converters;

import org.springframework.stereotype.Component;

import com.unla.trabajoPractico.entities.Rodado;
import com.unla.trabajoPractico.models.RodadoModel;

@Component("rodadoConverter")
public class RodadoConverter {
	
	public RodadoModel entityToModel(Rodado rodado) {
		return new RodadoModel(rodado.getIdRodado(), rodado.getDominio(), rodado.getVehiculo());
	}
	
	public Rodado modelToEntity(RodadoModel rodadoModel) {
		return new Rodado(rodadoModel.getIdRodado(), rodadoModel.getDominio(), rodadoModel.getVehiculo());
	}

}
