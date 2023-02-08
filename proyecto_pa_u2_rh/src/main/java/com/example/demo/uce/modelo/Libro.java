package com.example.demo.uce.modelo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

//Tabla principal con la tabla autor
@Entity
@Table(name="libro")
public class Libro {
	
	@Id
	@Column(name = "lib_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lib_sec") //Creo la secuencia a través de una secuencia-> name
	@SequenceGenerator (name= "lib_sec", sequenceName="lib_sec", allocationSize=1) 
	private Integer id;
	

	@Column(name = "lib_nombre")
	private String nombre;
	
	@Column (name = "lib_editorial")
	private String editorial;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="libro_autor", 
	joinColumns = @JoinColumn(name ="liau_id_libro"), //Ponemos el nombre de la tabla de rompimiento
	inverseJoinColumns = @JoinColumn(name= "liau_id_autor")) //La pk de autor
	private Set<Autor> autores;  //Conjunto

	public Integer getId() {
		return id;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + "]";
	}
	
	
	

}
