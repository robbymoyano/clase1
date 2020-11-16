package com.escuelita.clase1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuelita.clase1.mapper.EstudiantesMapper;
import com.escuelita.clase1.model.Estudiante;

@Service
public class EstudiantesService {

	@Autowired
	private EstudiantesMapper mapper;
	
	public List<Estudiante> getAllEstudiantes(){
		return mapper.getAllEstudiantes();
	}
}
