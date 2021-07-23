package com.escuelita.clase1.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Conversiones {
	/**
	 * 
	 * @param date     Fecha
	 * @param formato  Formato de salida, por ejemplo yyyy-MM-dd HH:mm:ss:SSS
	 * @param timeZone Zona horaria: America/Bogota, America/Santiago
	 * @return Fecha representada por un String
	 */
	public static String getFechabyTimeZone(Date date, String formato, String timeZone) {

		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(formato);
			final TimeZone zona = TimeZone.getTimeZone(timeZone);
			sdf.setTimeZone(zona);
			return sdf.format(date);
		} catch (Exception e) {
			
			return "";
		}
	}


}
