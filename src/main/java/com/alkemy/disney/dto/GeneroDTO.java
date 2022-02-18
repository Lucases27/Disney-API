package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroDTO {

	private Long id;
	private String nombre;
	private String imagen;
	private String pelicula;
	public String toString() {
		return this.nombre+this.imagen+this.pelicula;
	}
}