package com.escuelita.clase1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.escuelita.clase1.util.Validaciones;


public class TestValidaciones {

	@Test
	public void validarMail() {
		
		String email = "robbymoyano@gmail.com";
		boolean obtenido = Validaciones.validarEmail(email);
		Assertions.assertEquals(true, obtenido);
		
		email = "robby.moyano@gmail.com";
		obtenido = Validaciones.validarEmail(email);
		Assertions.assertEquals(true, obtenido);
		
		email = "robbymoyano@gmail.com.mx";
	    obtenido = Validaciones.validarEmail(email);
	    Assertions.assertEquals(true, obtenido);
		
		email = "robbymoyano";
		obtenido = Validaciones.validarEmail(email);
		Assertions.assertEquals(false, obtenido);
		
		email = "robbymoyano@gmail@.com";
		obtenido = Validaciones.validarEmail(email);
		Assertions.assertEquals(false, obtenido);
		
		email = "robbymoyano@com.";
		obtenido = Validaciones.validarEmail(email);
		Assertions.assertEquals(false, obtenido);
	}
}
