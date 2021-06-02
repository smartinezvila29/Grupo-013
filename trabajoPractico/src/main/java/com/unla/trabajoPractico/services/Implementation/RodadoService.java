package com.unla.trabajoPractico.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.trabajoPractico.converters.RodadoConverter;
import com.unla.trabajoPractico.entities.Rodado;
import com.unla.trabajoPractico.models.RodadoModel;
import com.unla.trabajoPractico.repositories.IRodadoRepository;
import com.unla.trabajoPractico.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	@Override
	public List<Rodado> getAll() {
		return rodadoRepository.findAll();
	}

	@Override
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel) {
		Rodado rodado = rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		return rodadoConverter.entityToModel(rodado);
	}

	@Override
	public boolean remove(int id) {
		try {
			rodadoRepository.delete(rodadoRepository.findByidRodado(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public RodadoModel findById(int id) {
		Rodado rodado = rodadoRepository.findByidRodado(id);
		return rodadoConverter.entityToModel(rodado);
	}
	

}
