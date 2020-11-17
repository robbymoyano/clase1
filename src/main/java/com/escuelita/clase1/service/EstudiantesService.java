package com.escuelita.clase1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.escuelita.clase1.exception.EstudiantesException;
import com.escuelita.clase1.mapper.EstudiantesMapper;
import com.escuelita.clase1.model.Estudiante;
import com.escuelita.clase1.model.EstudianteRequest;
import com.escuelita.clase1.model.Message;
import com.escuelita.clase1.util.Validaciones;

@Service
public class EstudiantesService {

	@Autowired
	private EstudiantesMapper mapper;

	private final Logger log = LoggerFactory.getLogger(EstudiantesService.class);

	public List<Estudiante> getAllEstudiantes() {
		return mapper.getAllEstudiantes();
	}

	public String getAllEstudiantesPlainText() {
		List<Estudiante> estudiantes = mapper.getAllEstudiantes();

		StringBuilder sbuilder = new StringBuilder();

		for (Estudiante e : estudiantes) {
			sbuilder.append(e.getRut() + "|");
			sbuilder.append(e.getNombre() + "|");
			sbuilder.append(e.getMail() + "|");
			sbuilder.append(e.getCiudad() + "\n");
		}

		return sbuilder.toString();
	}

	public Estudiante getEstudiante(long rut) {
		return mapper.getEstudiante(rut);
	}

	public Message ingresarEstudiante(EstudianteRequest request) throws EstudiantesException {
		log.info("SERVICE INIT {}", request.toString());

		boolean mailValido = Validaciones.validarEmail(request.getMail());
		log.info("{}", mailValido);

		if (!mailValido) {
			Message message = new Message(2, "Mail no valido");
			throw new EstudiantesException("Mail no valido", message, HttpStatus.BAD_REQUEST);
		}

		try {
			mapper.ingresarEstudiante(request.getRut(), request.getNombre(), request.getApellido(), request.getMail(),
					request.getCiudad());
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DataIntegrityViolationException) {
				Message message = new Message(2, e.getMessage());
				throw new EstudiantesException(e.getMessage(), message, HttpStatus.BAD_REQUEST);
			}
			Message message = new Message(2, "Error en la db");
			throw new EstudiantesException("Error en la db", message, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Message message = new Message(0, "OK");
		return message;

	}
	
	
	public List<Estudiante> getAllEstudiantesByCiudad(int idCiudad){
		return mapper.getAllEstudiantesByCiudad(idCiudad);
	}
}
