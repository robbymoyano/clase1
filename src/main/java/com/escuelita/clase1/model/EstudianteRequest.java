package com.escuelita.clase1.model;

public class EstudianteRequest {
	private long rut;
	private String nombre;
	private String apellido;
	private String mail;
	private int ciudad;

	public long getRut() {
		return rut;
	}

	public void setRut(long rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "EstudianteRequest [rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", ciudad=" + ciudad + "]";
	}

}
