package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	
	//http://localhost:8080/matriculas/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	private String nuevaMatricula (Matricula matricula) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/guardarMatricula")
	public String guardarMatricula (@RequestParam("cedula")String cedulaEstu,
			@RequestParam("cod1")String cod1,
			@RequestParam("cod2")String cod2,
			@RequestParam("cod3")String cod3,
			@RequestParam("cod4")String cod4)
	{
		
		this.iMatriculaService.guardarMatri(cedulaEstu, cod1, cod2, cod3, cod4);
		 return"redirect:/matriculas/nuevaMatricula";
	}

	//http://localhost:8080/matriculas/reporte
	@GetMapping("/reporte")
	public String reporte(Model modelo) {
	    List<MatriculaDTO>lista =this.iMatriculaService.reporte();
	    modelo.addAttribute("matriculas",lista);
		return"vistaListaMatriculas";
	}

	
	
	
}

