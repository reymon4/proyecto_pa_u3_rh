package com.example.demo.uce.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepoImpl implements IHabitacionRepo {

	@PersistenceContext
	private EntityManager em;
	@Override
	public void insertar(Habitacion hab) {
		// TODO Auto-generated method stub
		this.em.persist(hab);
	}

	@Override
	public void actualizar(Habitacion hab) {
		// TODO Auto-generated method stub
		this.em.merge(hab);
	}

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Habitacion.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion hab = this.buscar(id);
		this.em.remove(hab);
	}

}
