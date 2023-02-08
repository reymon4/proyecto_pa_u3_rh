package com.example.demo.uce.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="habitacion")
public class Habitacion {
	
	@Id
	@Column(name="hab_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hab_sec") //Creo la secuencia a través de una secuencia-> name
	@SequenceGenerator (name= "hab_sec", sequenceName="hab_sec", allocationSize=1) 
	private Integer id;
	
	@Column(name="hab_numero")
	private String numero;

	//@ManyToOne(cascade = CascadeType.MERGE) //muchos a uno
	@ManyToOne
	@JoinColumn(name="hab_id_hotel") //Nombre de la tabla con la que se va a relacionar
	private Hotel hotel;
	

	//Getters and Setters
		
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero +"]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	

}
