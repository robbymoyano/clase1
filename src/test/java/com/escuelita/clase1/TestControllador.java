package com.escuelita.clase1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

import com.escuelita.clase1.model.EstudianteRequest;
import com.escuelita.clase1.util.Utilidades;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllador {
	@Autowired
	private MockMvc mvc;
	
	/**
	 * Mas Info en: https://spring.io/guides/gs/testing-web/
	 * @throws Exception
	 */
	
	@Test
	public void getAllEstudiantes() throws Exception {
		mvc.perform(get("/api/estudiantes")).andExpect(status().isOk());
	}

	@Test
	public void getAllEstudiantesTextPlain() throws Exception {
		mvc.perform(get("/api/estudiantes").accept(MimeTypeUtils.TEXT_PLAIN_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void getEstudiante() throws Exception {
		mvc.perform(get("/api/estudiantes/9999999999").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound());
	}
	
	
	@Test
	public void insertEstudianteWithErrorMail() throws Exception {
		
		EstudianteRequest e = new EstudianteRequest();
		e.setRut(173880923);
		e.setNombre("Robby");
		e.setApellido("Moyano");
		e.setCiudad(3);
		e.setMail("robbymoyanogmail.com");

		
		String json = Utilidades.serializarObjeto(e);
		System.out.println(json);
				
		mvc.perform(post("/api/estudiantes").
				content(json).
				contentType(MimeTypeUtils.APPLICATION_JSON_VALUE)).
				andExpect(status().isBadRequest());
	}

}
