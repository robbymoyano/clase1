package com.escuelita.clase1;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import com.escuelita.clase1.exception.EstudiantesException;
import com.escuelita.clase1.mapper.EstudiantesMapper;
import com.escuelita.clase1.model.EstudianteRequest;
import com.escuelita.clase1.model.Message;
import com.escuelita.clase1.service.EstudiantesService;

@RunWith(MockitoJUnitRunner.class)
public class IngresaTest {

	@InjectMocks
	EstudiantesService service;

	@Mock
	EstudiantesMapper mapper;

	@Test
	public void testWhenDataIntegrityViolation() throws Exception {
		EstudianteRequest e = new EstudianteRequest();
		e.setRut(173880923);
		e.setNombre("Robby");
		e.setApellido("Moyano");
		e.setCiudad(3);
		e.setMail("robbymoyano@gmail.com");


		doThrow(DataIntegrityViolationException.class).when(mapper).ingresarEstudiante(e.getRut(), e.getNombre(),
				e.getApellido(), e.getMail(), e.getCiudad());

		try {
			Message message = service.ingresarEstudiante(e);

		} catch (EstudiantesException ex) {
			System.out.println(ex.getStatus());
			Assert.assertEquals(ex.getStatus(), HttpStatus.BAD_REQUEST);

		}
	}

	@Test
	public void testWhenErrorDB() throws Exception {
		EstudianteRequest e = new EstudianteRequest();
		e.setRut(173880923);
		e.setNombre("Robby");
		e.setApellido("Moyano");
		e.setCiudad(3);
		e.setMail("robbymoyano@gmail.com");

		doThrow(Exception.class).when(mapper).ingresarEstudiante(e.getRut(), e.getNombre(), e.getApellido(),
				e.getMail(), e.getCiudad());

		try {
			Message message = service.ingresarEstudiante(e);

		} catch (EstudiantesException ex) {
			System.out.println(ex.getStatus());
			Assert.assertEquals(ex.getStatus(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Test
	public void testWhenOK() throws Exception {
		EstudianteRequest e = new EstudianteRequest();
		e.setRut(173880923);
		e.setNombre("Robby");
		e.setApellido("Moyano");
		e.setCiudad(3);
		e.setMail("robbymoyano@gmail.com");

		try {
			Message message = service.ingresarEstudiante(e);
			Assert.assertEquals(message.getCode(), 0);

		} catch (EstudiantesException ex) {
			System.out.println(ex.getStatus());
		}
	}
}
