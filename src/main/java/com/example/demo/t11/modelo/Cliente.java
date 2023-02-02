package com.example.demo.t11.modelo;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	
	@Column(name = "cli_nombre")
	private String nombre;

	@Id
	@Column(name = "cli_cedula")
	private String cedula;
	
	@Column(name = "cli_pago")
	private String metodoPago;
	
	@Column(name = "cli_edad")
	private Integer edad;

	//@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Nombre de la colección que creamos en la clase vehiculo
	@OneToMany(mappedBy = "cliente")
	private List<Renta> rentas;

	
	
	//


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}



	
	//
	

	
}
