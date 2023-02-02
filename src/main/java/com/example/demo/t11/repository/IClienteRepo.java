package com.example.demo.t11.repository;

import com.example.demo.t11.modelo.Cliente;

public interface IClienteRepo {
	
	public void insertar(Cliente cli);
	public Cliente buscar(String cedula);
	public void actualizar(Cliente cli);
	public void eliminar(String cedula);
	

}
