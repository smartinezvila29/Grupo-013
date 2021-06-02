package com.unla.trabajoPractico.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.trabajoPractico.entities.Rodado;

@Repository("rodadoRepository")
public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{
	
	public abstract Rodado findByidRodado(int id);
	public abstract Rodado findBydominio(String dominio);
	public abstract Rodado findByvehiculo(String vehiculo);

}
