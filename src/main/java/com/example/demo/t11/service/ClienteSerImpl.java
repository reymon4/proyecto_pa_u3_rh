package com.example.demo.t11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.t11.modelo.Cliente;
import com.example.demo.t11.repository.IClienteRepo;

@Service
public class ClienteSerImpl implements IClienteSer{

	@Autowired
	private IClienteRepo cliRepo;
	
	@Override
	public void insertar(Cliente cli) {
		// TODO Auto-generated method stub
		this.cliRepo.insertar(cli);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.cliRepo.buscar(cedula);
	}

	@Override
	public void actualizar(Cliente cli) {
		// TODO Auto-generated method stub
		this.cliRepo.actualizar(cli);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.cliRepo.eliminar(cedula);
	}

}
