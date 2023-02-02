package com.example.demo.t11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.t11.repository.IVehiculoRepo;
import com.example.demo.t11.modelo.Vehiculo;


@Service
public class VehiculoSerImpl implements IVehiculoSer {

	@Autowired
	private IVehiculoRepo vehiRepo;
	
	@Override
	public void insertar(Vehiculo vehi) {
		// TODO Auto-generated method stub
		this.vehiRepo.insertar(vehi);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscar(placa);
	}

	@Override
	public void actualizar(Vehiculo vehi) {
		// TODO Auto-generated method stub
		this.vehiRepo.actualizar(vehi);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.vehiRepo.eliminar(placa);
	}
}
