package com.escuelita.clase1;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escuelita.clase1.service.EstudiantesService;

@SpringBootTest
public class TestService {

	@Autowired
	EstudiantesService service;
	
	@Test
	public void testearPlainTest() {
		String salida = service.getAllEstudiantesPlainText();
		System.out.println(salida);
	}
}
