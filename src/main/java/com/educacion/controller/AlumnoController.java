package com.educacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {

	@GetMapping("/alumno/cargar")
	public String cargarAlumno(){
		return "crudalumno";
	}
}
