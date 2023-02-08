package com.example.demo.uce.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepoImpl implements ILibroRepo{
	@PersistenceContext
	private EntityManager eM;
	
	
	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.eM.persist(libro);
	}

}
