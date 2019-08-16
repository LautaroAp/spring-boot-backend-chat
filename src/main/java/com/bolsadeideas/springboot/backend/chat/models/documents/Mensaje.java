package com.bolsadeideas.springboot.backend.chat.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable {

	// ==========================================================
	// ATRIBUTOS
	// ==========================================================

	private String texto;
	private Long fecha;
	private String username;
	private String tipo;
	
	private static final long serialVersionUID = 1L;
	
	// ==========================================================
	// METODOS
	// ==========================================================

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
