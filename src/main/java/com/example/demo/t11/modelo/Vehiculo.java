package com.example.demo.t11.modelo;

import java.math.BigDecimal;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;


@Entity
@Table(name="vehiculo")
public class Vehiculo {


	@Id
	@Column(name = "vehi_placa")
	private String placa;

	@Column (name = "vehi_color")
	private String color;
	
	@Column (name="vehi_modelo")
	private String modelo;
	
	@Column (name="vehi_precio")
	private BigDecimal precio; //Precio de la renta del vehículo

	//@OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)//Nombre de la colección que creamos en la clase vehiculo
	@OneToMany(mappedBy = "vehiculo")
	private List<Renta> rentas;
	
	
	///


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}

	

	
	
	
}
