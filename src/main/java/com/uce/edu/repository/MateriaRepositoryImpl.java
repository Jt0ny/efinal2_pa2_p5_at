package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia>query=this.entityManager.createQuery("select m from Materia m where m.codigo=:codigo",Materia.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
		
	}
	

}
