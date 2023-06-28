package com.educacion.controller;

import java.io.OutputStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.educacion.repository.IAlumnoRepository;
import com.educacion.repository.IProfesorRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReporteController {

	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	
	@Autowired
	private IAlumnoRepository repoAlu;
	
	@Autowired
	private IProfesorRepository repoProf;
	
	
	
	@GetMapping("/reporteListaAlumnos")
	public void listaAlumnos(HttpServletResponse response){
		response.setHeader("Content-Disposition", "inline;"); 
		response.setContentType("application/pdf");
		try {
			// recupera el recurso a cargar (jasper)
			String ru = resourceLoader.getResource("classpath:Reportes/listado_Alumnos.jasper").getURI().getPath();
			// "combinar" el jasper con la data / Ojo!  null -> el reporte no tiene parámetros!!
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			// java.io -> genera el archivo resultante
			OutputStream outStream = response.getOutputStream();
			// carga el archivo
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

