package com.example.demo.t11.service;

import com.example.demo.t11.modelo.Vehiculo;

public interface IVehiculoSer {
	public void insertar(Vehiculo vehi);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehi);
	public void eliminar(String placa);
}
