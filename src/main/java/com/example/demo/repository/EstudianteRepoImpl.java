package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	//Para no modificar el tipo de dato de retorno de los métodos, seguiremos
	//haciendo que devuelva solo un dato en la consulta.
	//EXCEPTO EN EL MÉTODO BUSCAR POR GÉNERO
	@Override
	public Estudiante buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub

		// select * from estudiante where estu_nombre = 'Reymon'
		// select e from Estudiante e where e.nombre = : datoNombre
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		// retorna un tipo de dato generico y toca castear
		return (Estudiante) jpqlQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
		jpqlQuery.setParameter("datoApellido", apellido);
		// retorna un tipo de dato generico y toca castear
		return (Estudiante) jpqlQuery.getSingleResult();
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		//EN ESTE MÉTODO RETORNAREMOS TODOS LOS OBJETOS QUE CONCUERDEN CON EL PARÁMETRO EN LA COLUMNA DE GÉNERO
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.genero = :datoGenero");
		jpqlQuery.setParameter("datoGenero", genero);
		// retorna un tipo de dato generico y toca castear
		return (List<Estudiante>) jpqlQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.ciudad = :datoCiudad");
		jpqlQuery.setParameter("datoCiudad", ciudad);
		// retorna un tipo de dato generico y toca castear
		return (Estudiante) jpqlQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		// retorna un tipo de dato generico y toca castear
		return (Estudiante) jpqlQuery.getSingleResult();
	}
	
	//TypedQuery

	@Override
	public Estudiante buscarPorNombreQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre",Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		//No hay que castear. Recibo directamente el tipo específico
		return myTypedQuery.getSingleResult();
	}

	
	//NamedQuery
	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPNNQ");
		myQuery.setParameter("datoNombre", nombre);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPNNQ",Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		//No hay que castear. Recibo directamente el tipo específico
		return myTypedQuery.getSingleResult();
	}

	
	//Native
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("select * from estudiante where estu_nombre=:datoNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	//Native, Named y Type
	@Override
	public Estudiante buscarPorNombreNativeQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPNNNQ", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		
		return myQuery.getSingleResult();
	}

	///////////LISTAS//////
	
	// query
		@Override
		public List<Estudiante> buscarPorNombreQueryList(String nombre) {
			Query jpqlQuery=this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
			jpqlQuery.setParameter("datoNombre",nombre);

			return jpqlQuery.getResultList();
		}

		//Named query
		@Override
		public List<Estudiante> buscarPorNombreNamedQueryList(String nombre) {
			Query myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPNNQ");
			myQuery.setParameter("datoNombre", nombre);
			return myQuery.getResultList();
		}

		//Native Query Typed Named
		@Override
		public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre) {
			TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPNNQ", Estudiante.class);
			myQuery.setParameter("datoNombre", nombre);
			return myQuery.getResultList();
		}

		//-------------------------------LISTAS CON PRIMER ELEMENTO----------------------------------------
		// query
		@Override
		public Estudiante buscarPorNombreQueryListFirstResult(String nombre) {
			Query jpqlQuery=this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
			jpqlQuery.setParameter("datoNombre",nombre);

			return (Estudiante) jpqlQuery.getResultList().get(0);
		}


		//DTO
			//Named Query Typed
		@Override
		public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre) {
			TypedQuery<EstudianteDTO> myTypedQuery=this.entityManager.createQuery("select NEW EstudianteDTO(e.nombre, e.apellido, e.cedula) from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
			myTypedQuery.setParameter("datoNombre", nombre);
			return myTypedQuery.getSingleResult();
		}
}
 