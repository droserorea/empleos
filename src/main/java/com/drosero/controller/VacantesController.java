package com.drosero.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drosero.model.Vacante;
import com.drosero.service.ICategoriasService;
import com.drosero.service.IVacanteService;
import com.drosero.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	@Autowired
	private IVacanteService serviceVacantes;
	@Autowired
	private ICategoriasService serviceCategorias;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> todasVacantes = serviceVacantes.buscarTodas();
		model.addAttribute("todasVacantes", todasVacantes);
		return "vacantes/listVacantes";
	}

	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		if (!multiPart.isEmpty()) {
			String ruta = "/home/drosero/empleos/img-vacantes/"; // Linux/MAC
			// String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}
		serviceVacantes.guardar(vacante);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Vacante: " + vacante);
		return "redirect:/vacantes/index";
	}

	/*
	 * @PostMapping("/save") public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("fecha") String fecha, @RequestParam("destacado") int
	 * destacado,
	 * 
	 * @RequestParam("salario") double salario, @RequestParam("archivoImagen")
	 * String archivoImagen,
	 * 
	 * @RequestParam("estatus") String estatus) {
	 * System.out.println("Nombre: "+nombre); System.out.println("Fecha: "+fecha);
	 * System.out.println("Descripcion: "+descripcion);
	 * System.out.println("Destacado: "+destacado);
	 * System.out.println("Salario: "+salario);
	 * System.out.println("Estatus: "+estatus); return "vacantes/listVacantes"; }
	 */

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Id obtenida: " + idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		System.out.println("Vacante: " + vacante);
		model.addAttribute("vacante", vacante);

		// Buscar los detalles en la vacante en la BD
		return "detalle";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
