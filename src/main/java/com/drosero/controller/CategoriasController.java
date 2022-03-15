package com.drosero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drosero.model.Categoria;
import com.drosero.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	private ICategoriasService serviceCategoria;
	
	// @GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> todasCategorias = serviceCategoria.buscarTodas();
		model.addAttribute("todasCategorias", todasCategorias);
		return "categorias/listCategorias";
	}

	// @GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}

	// @PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "categorias/formCategoria";
		}
		serviceCategoria.guardar(categoria);
		attributes.addFlashAttribute("msgCat", "CategoriaGuardada");
		return "redirect:/categorias/index";
	}
}
