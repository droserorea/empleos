package com.drosero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String verDetalle(int idVacante) {
		return "";
	}
}
