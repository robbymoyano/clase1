package com.escuelita.clase1;

import org.junit.Test;

import com.escuelita.clase1.util.Validaciones;

import junit.framework.Assert;

public class TestValidaciones {

	@Test
	public void validarMail() {
		
		String email = "robbymoyano@gmail.com";
		boolean obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(true, obtenido);
		
		email = "robby.moyano@gmail.com";
		obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(true, obtenido);
		
		email = "robbymoyano@gmail.com.mx";
	   obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(true, obtenido);
		
		email = "robbymoyano";
		obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(false, obtenido);
		
		email = "robbymoyano@gmail@.com";
		obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(false, obtenido);
		
		email = "robbymoyano@com.";
		obtenido = Validaciones.validarEmail(email);
		Assert.assertEquals(false, obtenido);
	}
}
