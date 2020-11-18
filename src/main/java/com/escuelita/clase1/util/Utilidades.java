package com.escuelita.clase1.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utilidades {
	/**
	 * Metodo que convierte un objeto a String con notación Json
	 * 
	 * @param object Objeto que se desea serializar
	 * @return Cadena Json
	 */
	public static String serializarObjeto(Object objeto) {
		ObjectMapper mapper = new ObjectMapper();

		String json = "";
		try {
			json = mapper.writeValueAsString(objeto);
			return json;
		} catch (JsonProcessingException e) {
			System.err.println("Error al serializar: "+ e.getMessage());
			return "";
		}
	}
}