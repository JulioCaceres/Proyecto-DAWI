package com.educacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educacion.model.Alumno;

import com.educacion.repository.IAlumnoRepository;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	private final IAlumnoRepository alumnoRepository;

	@Autowired
	public AlumnoController(IAlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@GetMapping("/listar")
	public String listarAlumnos(Model model) {
		model.addAttribute("alumnos", alumnoRepository.findAll());
		return "/Alumno/listar";
	}

//Probars
	@GetMapping("/registrar")
	public String mostrarFormularioRegistrar(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "/Alumno/registrar";
	}

//boton Registrar
	@PostMapping("/registrarBoton")
	public String registrarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoRepository.save(alumno);
		return "redirect:/alumnos/listar";
	}

	@GetMapping("/editar/{codigo_alum}")
	public String mostrarFormularioEditar(@PathVariable("codigo_alum") String codigoalum, Model model) {
		Alumno alumno = alumnoRepository.findById(codigoalum).orElse(null);
		model.addAttribute("alumno", alumno);
		return "/Alumno/editar";
	}
	
	
	@PostMapping("/editar")
    public String editarAlumno(@ModelAttribute("alumno") Alumno alumno) {
            alumnoRepository.save(alumno);
        return "redirect:/alumnos/listar";
    }
	
	 @GetMapping("/eliminar/{codigo_alum}")
	    public String eliminarAlumno(@PathVariable("codigo_alum") String codigoalum) {
	        alumnoRepository.deleteById(codigoalum);
	        return "redirect:/alumnos/listar";
	    }

}
