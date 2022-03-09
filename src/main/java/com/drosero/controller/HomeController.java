package com.drosero.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.drosero.model.Vacante;

@Controller
public class HomeController {
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante v1 = new Vacante();
		v1.setNombre("Ing.1");
		v1.setDescripcion("Ing. Ingeniero");
		v1.setFecha(new Date());
		v1.setSalario(700.0);
		model.addAttribute("v1", v1);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		lista.add("profesion 1");
		lista.add("profesion 2");
		lista.add("profesion 3");
		model.addAttribute("empleos", lista);
		return "listado";
	}
	@GetMapping("/")
	public String mostrarHome(Model model) {
//		model.addAttribute("mensaje","welcome to the app");
//		model.addAttribute("fecha", new Date());
		String nombre = "Aux. Contabilidad";
		Date fechaPub = new Date();
		double salario = 600;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "home";
	}
	
	private List<Vacante> getVacantes(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ing.1");
			v1.setDescripcion("Ing. Ingeniero");
			v1.setFecha(new Date());
			v1.setSalario(700.0);
			v1.setDestacado(1);
			v1.setImagen("e1.jpg");
			//v2
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Ing.2");
			v2.setDescripcion("Ing. Ingeniero 2");
			v2.setFecha(new Date());
			v2.setSalario(2200.0);
			v2.setDestacado(0);
			//v3
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Ing.3");
			v3.setDescripcion("Ing. Ingeniero 3");
			v3.setFecha(new Date());
			v3.setSalario(3300.0);
			v3.setDestacado(1);
			v3.setImagen("e3.jpg");
			
			//agregar objects
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
		}
		return lista;
	}

}
