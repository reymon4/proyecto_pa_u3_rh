package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.t11.modelo.Cliente;
import com.example.demo.t11.modelo.Vehiculo;
import com.example.demo.t11.service.IClienteSer;
import com.example.demo.t11.service.IRentaSer;
import com.example.demo.t11.service.IVehiculoSer;

@SpringBootApplication
public class Tarea11Application implements CommandLineRunner {

	@Autowired
	private IRentaSer renSer;
	
	@Autowired
	private IVehiculoSer vehiSer;
	
	@Autowired 
	private IClienteSer cliSer;
	public static void main(String[] args) {
		SpringApplication.run(Tarea11Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehi = new Vehiculo();
		vehi.setColor("Rojo");
		vehi.setModelo("Kia-Rio");
		vehi.setPlaca("PBO3610");
		vehi.setPrecio(new BigDecimal(20));
		this.vehiSer.insertar(vehi);
		
		Cliente cli = new Cliente();
		cli.setCedula("1720371333");
		cli.setEdad(23);
		cli.setMetodoPago("Efectivo");
		cli.setNombre("Reymon Hidalgo");
		this.cliSer.insertar(cli);
		
		
		this.renSer.realizar(vehi.getPlaca(), cli.getCedula());		
		
		System.out.println("Finish!");
		
		
		
	}

}
