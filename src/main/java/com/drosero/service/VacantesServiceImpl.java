package com.drosero.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drosero.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacanteService {
	
	private List<Vacante> lista = null;
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ing.1");
			v1.setDescripcion("Ing. Sistemas");
			v1.setFecha(new Date());
			v1.setSalario(700.0);
			v1.setDestacado(1);
			v1.setImagen("e1.jpg");
			// v2
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Ing.2");
			v2.setDescripcion("Ing. Ingeniero 2");
			v2.setFecha(new Date());
			v2.setSalario(2200.0);
			v2.setDestacado(0);
			// v3
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Ing.3");
			v3.setDescripcion("Ing. Ingeniero 3");
			v3.setFecha(new Date());
			v3.setSalario(3300.0);
			v3.setDestacado(1);
			v3.setImagen("e3.jpg");

			// agregar objects
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
	}

	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for (Vacante v : lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);		
	}

}
