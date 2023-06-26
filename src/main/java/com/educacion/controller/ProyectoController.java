package com.educacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {

	//Controller para iniciar la pagina
	 @GetMapping("/")
	public String cargarPagPrincipal() {
		return "Index";
	} 
}
