package com.escuelita.clase1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelita.clase1.model.Estudiante;
import com.escuelita.clase1.service.EstudiantesService;

@RestController
@RequestMapping("api")
public class EstudiantesController {

	@Autowired
	EstudiantesService estudiantesService;
	
	@GetMapping(value = "/estudiantes",  produces = { "application/json" })
	public List<Estudiante> getAllEstudiantes(){
		return estudiantesService.getAllEstudiantes();
	}
}
