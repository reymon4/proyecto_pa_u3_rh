package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.
				createQuery("select e from Estudiante e where e.nombre = :datoNombre",Estudiante.class);
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

	//NamedQueryTyped
	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.
				createNamedQuery("Estudiante.buscarPNNQ",Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		//No hay que castear. Recibo directamente el tipo específico
		return myTypedQuery.getSingleResult();
	}

	
	//Native
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.
				createNativeQuery("select * from estudiante where estu_nombre=:datoNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	//Native, Named y Type
	@Override
	public Estudiante buscarPorNombreNativeQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.
				createNamedQuery("Estudiante.buscarPNNNQ", Estudiante.class);
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
			Query jpqlQuery=this.entityManager.
					createQuery("select e from Estudiante e where e.nombre = :datoNombre");
			jpqlQuery.setParameter("datoNombre",nombre);

			return (Estudiante) jpqlQuery.getResultList().get(0);
		}


		//DTO
		//Named Query Typed
		@Override
		public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre) {
			TypedQuery<EstudianteDTO> myTypedQuery = this.entityManager
					 .createQuery("select NEW com.example.demo.modelo.dto.EstudianteDTO (e.nombre, e.apellido, e.cedula )from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
					 myTypedQuery.setParameter("datoNombre", nombre);
					return myTypedQuery.getSingleResult();
		}

		//Criteria API Query ----> query dinámico (Personalizado)
		
		@Override
		public List<Estudiante> buscarPorNombreQueryCriteria(String nombre) {
			// TODO Auto-generated method stub
			//Primera forma
			//TypedQuery <Estudiante> mQ = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre",Estudiante.class);
			//mQ.setParameter("datoNombre", nombre);
			//
			CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
			//Especificamos el tipo de retorno del query
			CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
			//Luego, creamos el SQL definiendo el FROM-Root (Método)
			Root<Estudiante> myTable = myQuery.from(Estudiante.class);
			//Las condiciones WHERE aquí se conocen como "predicados"
			Predicate condicion = myBuilder.equal(myTable.get("nombre"), nombre);//Ponemos el nombre del atributo
			//Finalmente, declaramos el Query
			myQuery.select(myTable).where(condicion);
			//Ahora, ejecutamos con cualquier tipo ya conocido. De preferencia, TYPEDQuery
			TypedQuery<Estudiante> mQ = this.entityManager.createQuery(myQuery);
			
			
			
			
			
			
			return mQ.getResultList();
		}

		//Criteria Lista AND y OR
		@Override
		public List<Estudiante> buscarPorNombreQueryCriteriaAndOr(String nombre, String apellido, String bandera) {//En vez de bandera será género
			
			// TODO Auto-generated method stub
			CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
			//Especificamos el tipo de retorno del query
			CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
			//Luego, creamos el SQL definiendo el FROM-Root (Método)
			Root<Estudiante> myTable = myQuery.from(Estudiante.class);
			
			//Las condiciones WHERE aquí se conocen como "predicados"
			//Armado dinámico. Ejemplo:
			//M: e.nombre = AND e.apellido=
			//F: e.nombre = OR e.apellido=
			
			Predicate condicion = myBuilder.equal(myTable.get("nombre"), nombre);
			Predicate condicion1 = myBuilder.equal(myTable.get("apellido"), apellido);	
			//Para la comparación del AND y el Or, tenemos que hacer otro predicado
			
			
			Predicate predicadoFinal = null;
			if(bandera.equals("M")) {
				predicadoFinal = myBuilder.and(condicion, condicion1);
			}else {
				predicadoFinal = myBuilder.or(condicion, condicion1);
			}
			
			//Finalmente, declaramos el Query
			myQuery.select(myTable).where(predicadoFinal);
			//Ahora, ejecutamos con cualquier tipo ya conocido. De preferencia, TYPEDQuery
			TypedQuery<Estudiante> mQ = this.entityManager.createQuery(myQuery);
			return mQ.getResultList();
		}

		@Override
		public int eliminarPorApellido(String apellido) {
			// TODO Auto-generated method stub
			//DELETE FROM estudiante where estu_apellido = "Hidalgo"
			Query query = this.entityManager.createQuery("DELETE FROM Estudiante e where e.apellido=:datoApellido"); //"JPQL"
			query.setParameter("datoApellido", apellido);
			return query.executeUpdate();
		}

		@Override
		public int actualizarPorApellido(String apellido, String nombre) {
			// TODO Auto-generated method stub
			//UPDATE estudiante set estu_nombre="Reymon" WHERE estu_apellido = "Beltrán"
			Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre=: datoNombre WHERE e.apellido=:datoApellido");
			query.setParameter("datoNombre", nombre);
			query.setParameter("datoApellido", apellido);
			
			return query.executeUpdate();
		}
}
 