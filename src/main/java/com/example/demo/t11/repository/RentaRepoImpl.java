package com.example.demo.t11.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.t11.modelo.Renta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RentaRepoImpl implements IRentaRepo{

	
	@PersistenceContext
	private EntityManager eM;
	@Override
	public void insertar(Renta ren) {
		// TODO Auto-generated method stub
		this.eM.persist(ren);
	}

	@Override
	public void actualizar(Renta ren) {
		// TODO Auto-generated method stub
		this.eM.merge(ren);
	}

	@Override
	public Renta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.eM.find(Renta.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Renta ren = this.buscar(id);
		this.eM.remove(ren);
	}

}
