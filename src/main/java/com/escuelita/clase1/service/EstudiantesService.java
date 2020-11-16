package com.escuelita.clase1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.escuelita.clase1.controller.EstudiantesController;
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
			Message message = new Message();
			message.setCode(2);
			message.setMessage("Mail no valido");
			throw new EstudiantesException("Mail no valido", message, HttpStatus.BAD_REQUEST);
		}

		mapper.ingresarEstudiante(request.getRut(), request.getNombre(), request.getApellido(), request.getMail(),
				request.getCiudad());
		Message message = new Message();
		message.setCode(0);
		message.setMessage("OK");
		return message;

	}
}
