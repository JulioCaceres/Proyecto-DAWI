package com.educacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacion.model.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, String>{

	// métodos básicos del CRUD
}
