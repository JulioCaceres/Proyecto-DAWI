package com.educacion.controller;

import com.educacion.model.Profesor;
import com.educacion.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    private final IProfesorRepository profesorRepository;

    @Autowired
    public ProfesorController(IProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @GetMapping("/listar")
    public String listarProfesores(Model model) {
        model.addAttribute("profesores", profesorRepository.findAll());
        return "/Profesor/listar";
    }

    //Prueba
    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "/Profesor/registrar";
    }

    @PostMapping("/registrar")
    public String registrarProfesor(@ModelAttribute("profesor") Profesor profesor) {
        profesorRepository.save(profesor);
        return "redirect:/profesores/listar";
    }

    @GetMapping("/editar/{codigo_prof}")
    public String mostrarFormularioEditar(@PathVariable("codigo_prof") String codigoProf, Model model) {
        Profesor profesor = profesorRepository.findById(codigoProf).orElse(null);
        model.addAttribute("profesor", profesor);
        return "/Profesor/editar";
    }

    @PostMapping("/editar")
    public String editarProfesor(@ModelAttribute("profesor") Profesor profesor) {
            profesorRepository.save(profesor);
        return "redirect:/profesores/listar";
    }

    @GetMapping("/eliminar/{codigo_prof}")
    public String eliminarProfesor(@PathVariable("codigo_prof") String codigoProf) {
        profesorRepository.deleteById(codigoProf);
        return "redirect:/profesores/listar";
    }
}
