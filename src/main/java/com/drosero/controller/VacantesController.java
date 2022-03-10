package com.drosero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drosero.model.Vacante;
import com.drosero.service.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	@Autowired
	private IVacanteService serviceVacantes;
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Id obtenida: "+idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		System.out.println("Vacante: "+vacante);
		model.addAttribute("vacante", vacante);
		
		//Buscar los detalles en la vacante en la BD
		return "detalle";
	}
}
