package com.drosero.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.drosero.model.Vacante;
import com.drosero.service.IVacanteService;

@Controller
public class HomeController {
	@Autowired
	private IVacanteService serviceVacantes;
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
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
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "home";
	}
	
	

}
