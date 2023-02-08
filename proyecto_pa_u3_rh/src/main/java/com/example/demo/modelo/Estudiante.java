package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "estudiante")
//@NamedQuery(name = "Estudiante.buscarPNNQ", query = "select e from Estudiante e where e.nombre = :datoNombre") //Anotación para el NamedQuery
//Named para listas
//Podemos agrupar en un solo grupo o hacer por separado
//Primer forma
//@NamedQuery(name = "Estudiante.buscarPNNQ1", query = "select e from Estudiante e where e.nombre = :datoNombre") //Anotación para el NamedQuery
//@NamedQuery(name = "Estudiante.buscarPNNQ2", query = "select e from Estudiante e where e.nombre = :datoNombre") //Anotación para el NamedQuery
//SegundaForma

@NamedQueries({@NamedQuery(name = "Estudiante.buscarPNNQ", query = "select e from Estudiante e where e.nombre = :datoNombre"),
			  @NamedQuery(name = "Estudiante.buscarPNNQ1", query = "select e from Estudiante e where e.nombre = :datoNombre"), 
			   @NamedQuery(name = "Estudiante.buscarPNNQ2", query = "select e from Estudiante e where e.nombre = :datoNombre")})


//Native para listas
//@NamedNativeQuery(name="Estudiante.buscarPNNNQ",query="select * from estudiante where estu_nombre=:datoNombre")



@NamedNativeQueries({@NamedNativeQuery(name="Estudiante.buscarPNNNQ",query="select * from estudiante where estu_nombre=:datoNombre"),
					@NamedNativeQuery(name="Estudiante.buscarPNNNQ1",query="select * from estudiante where estu_nombre=:datoNombre"),
					 @NamedNativeQuery(name="Estudiante.buscarPNNNQ2",query="select * from estudiante where estu_nombre=:datoNombre")})
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_seq")
	@SequenceGenerator(name = "estu_seq", sequenceName = "estu_seq", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_genero")
	private String genero;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_ciudad")
	private String ciudad;

	// Getters y setters
	public Integer getId() {
		return id;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", cedula=" + cedula + ", ciudad=" + ciudad + "]";
	}

}
