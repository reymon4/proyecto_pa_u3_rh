package com.example.demo.uce.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="autor")
public class Autor {
	
	@Id
	@Column(name = "autor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "autor_sec") //Creo la secuencia a través de una secuencia-> name
	@SequenceGenerator (name= "autor_sec", sequenceName="autor_sec", allocationSize=1) 
	private Integer id;
	
	@Column(name = "autor_nombre")
	private String nombre;

	
	@ManyToMany(mappedBy = "autores") //Nombre de la colección que creamos en la clase libro
	private Set<Libro> libros;
	
	

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + "]";
	}


	public Integer getId() {
		return id;
	}


	public Set<Libro> getLibros() {
		return libros;
	}


	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
