package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	
	public void insertar(Matricula matricula) {
	this.entityManager.persist(matricula);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarMatriculas() {
		TypedQuery<MatriculaDTO>query=this.entityManager.createQuery("select new "
				+ "com.uce.edu.repository.modelo.dto.MatriculaDTO"
				+ "(m.estudiante.cedula,m.materia.codigo,"
				+ "m.fechaMatricula,m.nombreHilo)"
				+ "FROM Matricula m",MatriculaDTO.class);
		return query.getResultList();
	}
	
	

}
