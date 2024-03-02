package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	
	//http://localhost:8080/estudiantes/nuevoEstudiante
	@GetMapping("/nuevoEstudiante")
	public String mostrarNuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}
	
	
	@PostMapping("/guardarEstudiante")
	public String guardarEstu(Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}

}
