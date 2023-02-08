package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.demo.uce.modelo.Ciudadano;
import com.example.demo.uce.modelo.Empleado;
import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.modelo.Habitacion;
import com.example.demo.uce.modelo.Hotel;
import com.example.demo.uce.modelo.Libro;
import com.example.demo.uce.modelo.Autor;
import com.example.demo.uce.service.ICiudadanoSer;
import com.example.demo.uce.service.IEmpleadoSer;
import com.example.demo.uce.service.IEstudianteService;
import com.example.demo.uce.service.IHabitacionService;
import com.example.demo.uce.service.IHotelService;
import com.example.demo.uce.service.ILibroSer;

@SpringBootApplication
public class ProyectoPaU2RhApplication implements CommandLineRunner{

	@Autowired
	private ILibroSer libroSer;

;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU2RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO Auto-generated method stub

		Libro l1 = new Libro();
		l1.setNombre("Análisis númerico");
		l1.setEditorial("Calvache");
		
		Set<Autor> autores = new HashSet<>();
		
		Autor a1 = new Autor();
		a1.setNombre("Oscar");
	
		Autor a2 = new Autor();
		a2.setNombre("David");
		
		Autor a3 = new Autor();
		a3.setNombre("Jimmy");
		
		
		autores.add(a3);
		autores.add(a2);
		autores.add(a1);
		
		
		
		
		l1.setAutores(autores);
		this.libroSer.insertar(l1);
		
		
		
		System.out.println("Finish!");
	}

}
