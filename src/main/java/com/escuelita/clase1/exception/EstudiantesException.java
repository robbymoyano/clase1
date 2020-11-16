package com.escuelita.clase1.exception;

import org.springframework.http.HttpStatus;

import com.escuelita.clase1.model.Message;

public class EstudiantesException extends Exception {

	private static final long serialVersionUID = -6579223498015302341L;
	
	private Message message;
	private HttpStatus status;
	
	public EstudiantesException(String msg, Message message, HttpStatus status) {
		super(msg);
		this.message = message;
		this.status = status;
	}

	public Message getMessageResponse() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
}
