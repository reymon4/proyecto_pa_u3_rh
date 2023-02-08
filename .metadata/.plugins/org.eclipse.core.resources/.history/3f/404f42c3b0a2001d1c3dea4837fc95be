package com.example.demo.t11.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.t11.modelo.Vehiculo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepo {

	@PersistenceContext
	private EntityManager eM;

	@Override
	public void insertar(Vehiculo vehi) {
		// TODO Auto-generated method stub
		this.eM.persist(vehi);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.eM.find(Vehiculo.class, placa);
	}

	@Override
	public void actualizar(Vehiculo vehi) {
		// TODO Auto-generated method stub
		this.eM.merge(vehi);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehi = this.buscar(placa);
		this.eM.remove(vehi);
	}



	}

	
