package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HabitacionRepoImpl implements IHabitacionRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Habitacion> buscarHabitacionOuterRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery=this.entityManager
				.createQuery("SELECT ha FROM Hotel h RIGHT JOIN h.habitaciones ha ",Habitacion.class);
		List<Habitacion> lista = myQuery.getResultList();
	
		return lista;
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery=this.entityManager
				.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha ",Habitacion.class);
		List<Habitacion> lista = myQuery.getResultList();
	
		return lista;
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterFullJoin() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
