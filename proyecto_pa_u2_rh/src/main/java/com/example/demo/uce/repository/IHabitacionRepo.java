package com.example.demo.uce.repository;

import com.example.demo.uce.modelo.Habitacion;


public interface IHabitacionRepo {

public void insertar(Habitacion hab);
	
	public void actualizar(Habitacion hab);
	//CRUD siempre por pk
	public Habitacion buscar(Integer id);
	
	public void eliminar(Integer id);
}


