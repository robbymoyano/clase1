package com.escuelita.clase1.blobstorage;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuelita.clase1.config.CloudBlobConfig;
import com.escuelita.clase1.util.Conversiones;
import com.microsoft.azure.storage.blob.CloudAppendBlob;

@Service
public class BlobAppendService {

	@Autowired
	private CloudBlobConfig provider;

	private final Logger log = LoggerFactory.getLogger(BlobAppendService.class);

	/**
	 * Metodo que agrega información al final del archivo Log
	 * 
	 * @param orderNumber Numero de OC o Numero de NC
	 * @param body        Request procesado
	 * @param errorString Cadena con la información del error
	 * @throws Exception
	 */
	public void registrarLog(long orderNumber, String body, String errorString) {

		Calendar calendar = Calendar.getInstance();
		String fecha = Conversiones.getFechabyTimeZone(calendar.getTime(), "yyyy-MM-dd", "America/Bogota");
		String nombreArchivo = provider.getBlob() + "_" + fecha + ".log";

		log.info("Append archivo datacollect {}", nombreArchivo);
		try {
			CloudAppendBlob appendBlob = provider.getBlobClientReference().getAppendBlobReference(nombreArchivo);

			log.info("existirá el archivo");
			boolean existe = appendBlob.exists();
			log.info("el archivo existe ? {}", existe);

			if (!existe) {
				// se debe incorporar esta linea solo cuando se
				// está creando el archivo
				appendBlob.createOrReplace();
			}
			appendBlob.appendText(
					"Error: documento[" + orderNumber + "], Error[" + errorString + "], Request[" + body + "]\n");
			log.info("Se agrega data al archivo {}", nombreArchivo);
		} catch (Exception e) {
			log.error("Error en el blob {}", e.getMessage());

		}
	}
        public void registrarLog(String body, String optionalBodyAppend) {

		Calendar calendar = Calendar.getInstance();
		String fecha = Conversiones.getFechabyTimeZone(calendar.getTime(), "yyyy-MM-dd", "America/Bogota");
		String nombreArchivo = provider.getBlob() + "_" + fecha + ".log";

		log.info("Append archivo datacollect {}", nombreArchivo);
		try {
			CloudAppendBlob appendBlob = provider.getBlobClientReference().getAppendBlobReference(nombreArchivo);

			log.info("existirá el archivo");
			boolean existe = appendBlob.exists();
			log.info("el archivo existe ? {}", existe);

			if (!existe) {
				// se debe incorporar esta linea solo cuando se
				// está creando el archivo
				appendBlob.createOrReplace();
			}
			appendBlob.appendText(
					body + " " + optionalBodyAppend + "\n");
			log.info("Se agrega data al archivo {}", nombreArchivo);
		} catch (Exception e) {
			log.error("Error en el blob {}", e.getMessage());

		}
	}
}
