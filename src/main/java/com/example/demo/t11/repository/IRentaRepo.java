package com.example.demo.t11.repository;

import com.example.demo.t11.modelo.Renta;

public interface IRentaRepo {
	
	
	public void insertar(Renta ren);
	public void actualizar(Renta ren);
	public Renta buscar(Integer id);
	public void eliminar(Integer id);
	
	
	

}
