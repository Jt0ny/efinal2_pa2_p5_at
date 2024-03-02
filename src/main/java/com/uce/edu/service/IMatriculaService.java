package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {
	
	public void guardarMatri(String cedulaEstu, String cod1,String cod2,String cod3,String cod4);
	
	
	public List<MatriculaDTO> reporte ();
	

}
