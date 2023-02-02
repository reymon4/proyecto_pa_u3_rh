package com.example.demo.t11.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.t11.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo{

	@PersistenceContext
	private EntityManager eM;
	
	
	@Override
	public void insertar(Cliente cli) {
		// TODO Auto-generated method stub
		this.eM.persist(cli);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.eM.find(Cliente.class, cedula);
	}

	@Override
	public void actualizar(Cliente cli) {
		// TODO Auto-generated method stub
		this.eM.merge(cli);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Cliente cli = this.buscar(cedula);
		this.eM.remove(cli);
	}

}
