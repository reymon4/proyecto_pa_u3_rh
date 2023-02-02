package com.example.demo.t11.repository;

import com.example.demo.t11.modelo.Vehiculo;

public interface IVehiculoRepo {
	
	public void insertar(Vehiculo vehi);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehi);
	public void eliminar(String placa);

}
