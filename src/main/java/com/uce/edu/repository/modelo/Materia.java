package com.uce.edu.repository.modelo;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	
	@GeneratedValue(generator ="seq_materia",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_materia",sequenceName = "seq_materia",allocationSize = 1)
	@Id
	@Column(name = "mate_id")
	private Integer id;
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_codigo")
	private String codigo;
	
	@Column(name = "mate_numCreditos")
	private String numCreditos;
	
	@Column(name = "mate_cedulaProf")
	private String cedulaProf;
	
	@OneToMany(mappedBy = "materia")
	private List<Matricula> matriculas;

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(String numCreditos) {
		this.numCreditos = numCreditos;
	}

	public String getCedulaProf() {
		return cedulaProf;
	}

	public void setCedulaProf(String cedulaProf) {
		this.cedulaProf = cedulaProf;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	
	
	
	

}
