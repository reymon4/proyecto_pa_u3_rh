package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo{
		@PersistenceContext
		private EntityManager eM;
	
	
	@Override
	public void insertar(Estudiante estu) {
		// TODO Auto-generated method stub
		this.eM.persist(estu);
	}

}
