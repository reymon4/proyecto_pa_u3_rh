package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class CiudadanoRepoImpl implements ICiudadanoRepo{
	@PersistenceContext
	private EntityManager eM;

	@Override
	public List<Ciudadano> consultarTodos(Integer id) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.eM.createQuery("select c from Ciudadano e where e.id = :dato");
		jpqlQuery.setParameter("dato", id);
		// retorna un tipo de dato generico y toca castear
		return (List<Ciudadano>) jpqlQuery.getResultList();
	}

	@Override
	public void insertar(Ciudadano ciu) {
		// TODO Auto-generated method stub
		this.eM.persist(ciu);
	}

}
