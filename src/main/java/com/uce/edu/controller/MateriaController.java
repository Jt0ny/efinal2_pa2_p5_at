package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	
	//http://localhost:8080/materias/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String nuevaMateria(Materia materia) {
		return"vistaNuevaMateria";
	}
	
	@PostMapping("/guardarMateria")
	public String guardarMate(Materia materia) {
		this.iMateriaService.guardarMateria(materia);
		return "redirect:/materias/nuevaMateria";
		
	}
	

}
