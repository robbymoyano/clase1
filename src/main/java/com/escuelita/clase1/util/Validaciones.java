package com.escuelita.clase1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	
	public static boolean validarEmail(String email) {
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		Pattern pattern = Pattern.compile(emailPattern);
		System.out.println("analizando el mail " + email);
		if (email != null) {
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches())
				return true;
			else
				return false;
		} else
			return false;

	}

}
