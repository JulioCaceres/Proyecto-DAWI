package com.educacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacion.model.Alumno;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, String> {

	// métodos básicos del CRUD
}
