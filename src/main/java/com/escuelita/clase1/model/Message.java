package com.escuelita.clase1.model;

public class Message {

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", message=" + message + "]";
	}

	public Message(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public Message() {
	
	}
	

}
