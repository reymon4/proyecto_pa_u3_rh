package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

public interface IEstudianteService {

	public Estudiante buscarPorNombre(String nombre);

	public Estudiante buscarPorApellido(String apellido);
	
	public void insertar(Estudiante estudiante);
	
	
	public List<Estudiante> buscarPorGenero(String genero);
	
	public Estudiante buscarPorCiudad(String ciudad);
	
	public Estudiante buscarPorCedula(String cedula);

	

	//TypeQuery
	
	public Estudiante buscarPorNombreQueryTyped(String nombre);

	//NamedQuery-->Damos un alias
		public Estudiante buscarPorNombreNamedQuery(String nombre);
		
	//Combinación de Named y Type
		public Estudiante buscarPorNombreNamedQueryTyped(String nombre);

		
		//Native Query
		
		public Estudiante buscarPorNombreNativeQuery(String nombre);
		
	//Combinación Native, Nammed y Type
		public Estudiante buscarPorNombreNativeQueryTyped(String nombre);
		
		
		
	//Listas
		
		public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre);
		
		public List<Estudiante> buscarPorNombreNamedQueryList(String name);
		
		public List<Estudiante> buscarPorNombreQueryList(String nombre);
		
		public Estudiante buscarPorNombreQueryListFirstResult(String nombre);

		
		//DTO
		
		public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre);



		//Criteria API Query ----> query dinámico (Personalizado)
		
		
		public List<Estudiante> buscarPorNombreQueryCriteria(String nombre);
		
		//Lista Criteria con and y or
		public List<Estudiante> buscarPorNombreQueryCriteriaAndOr(String nombre, String apellido, String bandera);
}
