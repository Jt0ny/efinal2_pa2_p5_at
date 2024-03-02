package com.uce.edu.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula {
	
	@GeneratedValue(generator ="seq_matricula",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_matricula",sequenceName = "seq_matricula",allocationSize = 1)
	@Id
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_fechaMatricula")
	private  LocalDate fechaMatricula;
	
	@Column(name = "matr_nombreHilo")
	private String nombreHilo;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;

	
	//get y set 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", nombreHilo=" + nombreHilo
				+ ", estudiante=" + estudiante + ", materia=" + materia + "]";
	}

	

}
