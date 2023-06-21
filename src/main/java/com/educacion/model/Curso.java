package com.educacion.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_curso")
public class Curso {
	@Id
	private String  codigo_curso;
	private String  nombre_curso;
	private Date  fechinicio_curso;
	private Date  fechfin_curso;
	private String  codigo_prof;
}
