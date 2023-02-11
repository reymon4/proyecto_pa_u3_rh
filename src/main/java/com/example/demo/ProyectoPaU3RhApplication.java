package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.repository.EstudianteRepoImpl;
import com.example.demo.service.IEstudianteService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootApplication
public class ProyectoPaU3RhApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private EstudianteRepoImpl estudianteRepoImpl;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.out.println(this.estudianteService.buscarPorNombre("Daniel"));
		//System.out.println(this.estudianteService.buscarPorGenero("F"));
		//System.out.println(this.estudianteService.buscarPorApellido("Mancheno"));
		//System.out.println(this.estudianteService.buscarPorCedula("1720371333"));
		//System.out.println(this.estudianteService.buscarPorNombreQueryTyped("Reymon"));
		//System.out.println(this.estudianteService.buscarPorNombreNamedQuery("Daniel"));
		//System.out.println(this.estudianteService.buscarPorNombreNamedQueryTyped("Reymon"));
		//System.out.println(this.estudianteService.buscarPorNombreNativeQuery("Luz"));
		//System.out.println(this.estudianteService.buscarPorNombreNativeQueryTyped("Andres"));
		
		
		

				//-------------------------------LISTAS----------------------------------------
				// QUERY list
				System.out.println("Query");
				List<Estudiante>  lista1_estu=this.estudianteService.buscarPorNombreQueryList("Luz");
				lista1_estu.forEach(System.out::println);

				//eNamedQueryList
				System.out.println("NamedQueryList");
				List<Estudiante>  lista2_estu=this.estudianteService.buscarPorNombreNamedQueryList("Reymon");
				lista2_estu.forEach(System.out::println);

				//NativeQueryTypedNamedList
				System.out.println("NativeQueryTypedNamedList");
				List<Estudiante>  lista3_estu=this.estudianteService.buscarPorNombreNativeQueryTypedNamedList("Daniel");
				lista3_estu.forEach(System.out::println);


				// Query 
				System.out.println("Query");
				Estudiante estu0=this.estudianteService.buscarPorNombreQueryListFirstResult("Zoila");
				System.out.println(estu0);
				
				//DTO
				System.out.println("DTO");
				//EstudianteDTO estu2 = this.estudianteService.buscarPorNombreQueryTypedDTO("Reymon");
				System.out.println(this.estudianteService.buscarPorNombreQueryTypedDTO("Daniel"));
				
				//Criteria API QUERY
				System.out.println("Criteria API QUERY");
				System.out.println(this.estudianteService.buscarPorNombreQueryCriteria("Reymon"));
				
				//CRITERIA con AND y OR
				System.out.println("Criteria AND y OR");
				System.out.println(this.estudianteService.buscarPorNombreQueryCriteriaAndOr("Reymon", "Hidalgo", "M"));
	}

}
