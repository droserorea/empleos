package com.drosero.service;

import java.util.List;

import com.drosero.model.Vacante;

public interface IVacanteService {
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
}
