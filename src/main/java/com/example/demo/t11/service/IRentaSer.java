package com.example.demo.t11.service;

import com.example.demo.t11.modelo.Renta;

public interface IRentaSer {
	public void realizar(String placa, String cedula);
	public void actualizar(Renta ren);
	public Renta buscar(Integer id);
	public void eliminar(Integer id);
	

}
