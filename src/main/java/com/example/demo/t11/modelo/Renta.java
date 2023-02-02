package com.example.demo.t11.modelo;



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
@Table(name="renta")
public class Renta {
	
	@Id
	@Column(name = "ren_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ren_sec") //Creo la secuencia a través de una secuencia-> name
	@SequenceGenerator (name= "ren_sec", sequenceName="ren_sec", allocationSize=1) 
	private Integer id;
	
	@Column(name="ren_dias")
	private Integer dias;
	
	@ManyToOne(cascade = CascadeType.ALL) //muchos a uno
	//@ManyToOne
	@JoinColumn(name="ren_id_vehiculo") //Nombre de la tabla con la que se va a relacionar
	private Vehiculo vehiculo;
	
	
	@ManyToOne(cascade = CascadeType.ALL) //muchos a uno
	//@ManyToOne
	@JoinColumn(name="ren_id_cliente") //Nombre de la tabla con la que se va a relacionar
	private Cliente cliente;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDias() {
		return dias;
	}


	public void setDias(Integer dias) {
		this.dias = dias;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
