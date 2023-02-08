package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.modelo.Habitacion;
import com.example.demo.uce.repository.IHabitacionRepo;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

	
	@Autowired
	private IHabitacionRepo habRepo;
	@Override
	public void actualizar(Habitacion hab) {
		// TODO Auto-generated method stub
		this.habRepo.actualizar(hab);
	}

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.habRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.habRepo.eliminar(id);
	}

	@Override
	public void insertar(Habitacion hab) {
		// TODO Auto-generated method stub
		this.habRepo.insertar(hab);
	}

}
