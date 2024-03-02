package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	
	public void actualizar (Materia materia);
	
	public Materia seleccionarPorCodigo(String codigo);

}
