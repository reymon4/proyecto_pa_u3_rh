package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Ciudadano;

public interface ICiudadanoRepo {
	public List<Ciudadano> consultarTodos(Integer id);

	public void insertar(Ciudadano ciu);
}
