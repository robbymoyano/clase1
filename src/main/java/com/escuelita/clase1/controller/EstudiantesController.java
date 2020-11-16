package com.escuelita.clase1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelita.clase1.model.Estudiante;
import com.escuelita.clase1.model.Message;
import com.escuelita.clase1.service.EstudiantesService;

@RestController
@RequestMapping("api")
public class EstudiantesController {

	@Autowired
	EstudiantesService estudiantesService;

	private final Logger log = LoggerFactory.getLogger(EstudiantesController.class);

	@GetMapping(value = "/estudiantes", produces = { "application/json" })
	public ResponseEntity<Object> getAllEstudiantes() {
		try {
			List<Estudiante> estudiantes = estudiantesService.getAllEstudiantes();
			return new ResponseEntity<Object>(estudiantes, HttpStatus.OK);
		} catch (Exception e) {

			Message message = new Message();
			message.setCode(2);
			message.setMessage(e.getMessage());
			return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/estudiantes", produces = { "text/plain" })
	public String getAllEstudiantesTextPlain() {
		return estudiantesService.getAllEstudiantesPlainText();
	}

	@GetMapping(value = "/estudiantes/{rut}", produces = { "application/json" })
	public ResponseEntity<Object> getAllEstudiante(@PathVariable("rut") String rut) {
		long rutLong =0;
		try {
			rutLong = Long.parseLong(rut);
		}
		catch(Exception e) {
			Message message = new Message();
			message.setCode(6);
			message.setMessage("Rut no valido");
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		}
		Estudiante estudiante = estudiantesService.getEstudiante(rutLong);
		if (estudiante != null) {
			log.info(estudiante.toString());
			return new ResponseEntity<Object>(estudiante, HttpStatus.OK);
		}

		else {
			Message message = new Message();
			message.setCode(5);
			message.setMessage("No existe rut");
			return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
		}
	}

}
