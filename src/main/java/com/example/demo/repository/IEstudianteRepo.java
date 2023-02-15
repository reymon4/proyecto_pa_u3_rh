package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

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
//
	
	
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
	
	
	
	//eliminar
	public int eliminarPorApellido(String apellido);
	//Actualizar
	public int actualizarPorApellido(String apellido, String nombre); //Parámetro, dato que quiero actualizar
	
	//------------JOINS----------
	//3 tipos principales
	//1. JOIN 
	//1.1 INNER JOIN (DATOS QUE SE CRUZAN ENTRE TABLAS - INTERSERCCIÓN)
	//1.2 OUTER JOIN --> Right join, Left join , full outer join (Datos que se cruzan más datos que se especifican)
	
	
	
	//2. JOIN WHERE (Búsquedas con claves primarias de una tabla A en una B sin usar "JOIN")
	
	
	
	//3. JOIN FETCH es exclusivo de Jakarta. Se usa para ver relaciones de tablas hijas.
	//Es una alternativa al Igger y al lazy de una manera más eficiente
	
	
	
	
	
	
	


}
