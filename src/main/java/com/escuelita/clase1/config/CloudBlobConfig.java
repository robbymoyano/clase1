package com.escuelita.clase1.config;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Configuration
public class CloudBlobConfig {

	@Value("${storage.connectionString}")
	private String connectionString;
	
	@Value("${storage.container}")
	private String containerName;
	
	@Value("${storage.blob}")
	private String blob;
	
	private final Logger log = LoggerFactory.getLogger(CloudBlobConfig.class);

	/**
	 * Método que retorna un objeto CloudBlobContainer, obtiene las credenciales y
	 * el nombre del contenedor del archivo de propiedades
	 * @return CloudBlobContainer
	 * @throws Exception
	 */
	@Bean
	public CloudBlobContainer getBlobClientReference() throws Exception {

		CloudStorageAccount storageAccount;
		log.info("CREANDO BEAN PARA BLOB");
		try {
			storageAccount = CloudStorageAccount.parse(connectionString);
		} catch (IllegalArgumentException | URISyntaxException e) {
			log.error("Connection string specifies an invalid URI.");
			log.error("Please confirm the connection string is in the Azure connection string format.");
			throw e;
		} catch (InvalidKeyException e) {
			log.error("Connection string specifies an invalid key.");
			log.error("Please confirm the AccountName and AccountKey in the connection string are valid.");
			throw e;
		}
		catch (Exception e) {
			log.error("{}", e.getMessage());
			throw e;
			
		}

		// Create a new container
		CloudBlobContainer container = storageAccount.createCloudBlobClient().getContainerReference(containerName);
		try {
			if (container.createIfNotExists() == false) {
				log.info("Container with name {} already exists.", containerName);
			}
		} catch (StorageException s) {
			log.error("{}", s.getMessage());
			if (s.getCause() instanceof java.net.ConnectException) {
				log.error(
						"Caught connection exception from the client. If running with the default configuration please make sure you have started the storage emulator.");
			}
			throw s;
		}
		log.info("BEAN PARA BLOB FINALIZADO");
		return container;
	}

	@Bean
	public String getBlob() {
		return blob;
	}
}
