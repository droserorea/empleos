package com.drosero.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drosero.model.Categoria;
import com.drosero.model.Vacante;

@Service
public class CategoriasServiceImpl implements ICategoriasService{
	private List<Categoria> listaCategorias = null;
	
	

	public CategoriasServiceImpl() {
		listaCategorias = new LinkedList<Categoria>();
		try {
			Categoria cat1 =  new Categoria();
			cat1.setId(1);
			cat1.setNombre("TI");;
			cat1.setDescripcion("Tech e informacion");
			
			Categoria cat2 =  new Categoria();
			cat2.setId(2);
			cat2.setNombre("Contabilidad");;
			cat2.setDescripcion("Adm. y contabilidad");
			
			Categoria cat3 =  new Categoria();
			cat3.setId(1);
			cat3.setNombre("Salud");;
			cat3.setDescripcion("Medicina y Salud");
			
			listaCategorias.add(cat1);
			listaCategorias.add(cat2);
			listaCategorias.add(cat3);
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	@Override
	public void guardar(Categoria categoria) {
		listaCategorias.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria	c : listaCategorias) {
			if(c.getId()==idCategoria) {
				return c;
			}
		}
		return null;
	}
	
	

}
