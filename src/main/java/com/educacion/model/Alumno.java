package com.educacion.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_alumno")
public class Alumno {
	@Id 
	private String  codigo_alum;
	private String  nombre_alum;
	private String  apellido_alum;
	private String  numerodocumento_alum;
	private String  nacionalidad_alum;
	private String  correo_alum;
	private String  celular_alum;
	private Date  fechanacimiento_alum;
	
	public String getCodigo_alum() {
		return codigo_alum;
	}
	public void setCodigo_alum(String codigo_alum) {
		this.codigo_alum = codigo_alum;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getApellido_alum() {
		return apellido_alum;
	}
	public void setApellido_alum(String apellido_alum) {
		this.apellido_alum = apellido_alum;
	}
	public String getNumerodocumento_alum() {
		return numerodocumento_alum;
	}
	public void setNumerodocumento_alum(String numerodocumento_alum) {
		this.numerodocumento_alum = numerodocumento_alum;
	}
	public String getNacionalidad_alum() {
		return nacionalidad_alum;
	}
	public void setNacionalidad_alum(String nacionalidad_alum) {
		this.nacionalidad_alum = nacionalidad_alum;
	}
	public String getCorreo_alum() {
		return correo_alum;
	}
	public void setCorreo_alum(String correo_alum) {
		this.correo_alum = correo_alum;
	}
	public String getCelular_alum() {
		return celular_alum;
	}
	public void setCelular_alum(String celular_alum) {
		this.celular_alum = celular_alum;
	}
	public Date getFechanacimiento_alum() {
		return fechanacimiento_alum;
	}
	public void setFechanacimiento_alum(Date fechanacimiento_alum) {
		this.fechanacimiento_alum = fechanacimiento_alum;
	}
	
	

}
