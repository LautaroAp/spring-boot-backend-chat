package com.bolsadeideas.springboot.backend.chat.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable {

	// ==========================================================
	// ATRIBUTOS
	// ==========================================================

	private String texto;
	private Long fecha;
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
	
}
