package com.escuelita.clase1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escuelita.clase1.service.EstudiantesService;

@RunWith(SpringRunner.class)
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
