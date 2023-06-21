package com.educacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacion.model.Profesor;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, String> {
	// métodos básicos del CRUD
}
