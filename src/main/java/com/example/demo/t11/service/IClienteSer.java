package com.example.demo.t11.service;

import com.example.demo.t11.modelo.Cliente;

public interface IClienteSer {
	public void insertar(Cliente cli);
	public Cliente buscar(String cedula);
	public void actualizar(Cliente cli);
	public void eliminar(String cedula);

}
