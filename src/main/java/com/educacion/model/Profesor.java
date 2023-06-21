package com.educacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_profesor")
public class Profesor {
	@Id
	private String  codigo_prof;
	private String  nombre_prof;
	private String  apellido_prof;
	private String  numerodocumento_prof;
	private String  nacionalidad_prof;
	private String  celular_prof;
	private String  correo_prof;
	private String  espe_prof;
	
	public String getCodigo_prof() {
		return codigo_prof;
	}
	public void setCodigo_prof(String codigo_prof) {
		this.codigo_prof = codigo_prof;
	}
	public String getNombre_prof() {
		return nombre_prof;
	}
	public void setNombre_prof(String nombre_prof) {
		this.nombre_prof = nombre_prof;
	}
	public String getApellido_prof() {
		return apellido_prof;
	}
	public void setApellido_prof(String apellido_prof) {
		this.apellido_prof = apellido_prof;
	}
	public String getNumerodocumento_prof() {
		return numerodocumento_prof;
	}
	public void setNumerodocumento_prof(String numerodocumento_prof) {
		this.numerodocumento_prof = numerodocumento_prof;
	}
	public String getNacionalidad_prof() {
		return nacionalidad_prof;
	}
	public void setNacionalidad_prof(String nacionalidad_prof) {
		this.nacionalidad_prof = nacionalidad_prof;
	}
	public String getCelular_prof() {
		return celular_prof;
	}
	public void setCelular_prof(String celular_prof) {
		this.celular_prof = celular_prof;
	}
	public String getCorreo_prof() {
		return correo_prof;
	}
	public void setCorreo_prof(String correo_prof) {
		this.correo_prof = correo_prof;
	}
	public String getEspe_prof() {
		return espe_prof;
	}
	public void setEspe_prof(String espe_prof) {
		this.espe_prof = espe_prof;
	}

	
	
}
