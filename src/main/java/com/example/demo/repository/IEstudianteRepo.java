package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepo {
	//Query
	public Estudiante buscarPorNombre(String nombre);

	public Estudiante buscarPorApellido(String apellido);

	public void insertar(Estudiante estudiante);
	
	public List<Estudiante> buscarPorGenero(String genero);

	public Estudiante buscarPorCiudad(String ciudad);
	
	public Estudiante buscarPorCedula(String cedula);

	//TypeQuery-->Tipo específico de objeto
	
	public Estudiante buscarPorNombreQueryTyped(String nombre);
	
	
	//Native Query
	
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	
//Combinación Native, Nammed y Type
	public Estudiante buscarPorNombreNativeQueryTyped(String nombre);
	
	
	//NamedQuery-->Damos un alias
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	
	//Combinación de Named y Type
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
}

