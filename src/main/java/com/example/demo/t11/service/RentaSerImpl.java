package com.example.demo.t11.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.t11.modelo.Cliente;
import com.example.demo.t11.modelo.Renta;
import com.example.demo.t11.modelo.Vehiculo;
import com.example.demo.t11.repository.IClienteRepo;
import com.example.demo.t11.repository.IRentaRepo;
import com.example.demo.t11.repository.IVehiculoRepo;

@Service
public class RentaSerImpl implements IRentaSer {
	@Autowired
	private IRentaRepo renRepo;
	
	@Autowired 
	private IClienteRepo cliRepo;
	
	@Autowired
	private IVehiculoRepo vehiRepo;
	
	@Override
	public void realizar(String placa, String cedula) {
		// TODO Auto-generated method stub
		Cliente cli = this.cliRepo.buscar(cedula);
		Vehiculo vehi = this.vehiRepo.buscar(placa);
		Renta ren = new Renta();
		ren.setCliente(cli);
		ren.setVehiculo(vehi);
		ren.setDias(8);
		//Vamos a decir que el valor de la renta es igual al número de días por el valor del auto
		BigDecimal valPagar = vehi.getPrecio().multiply(new BigDecimal(ren.getDias()));
		this.renRepo.actualizar(ren);
		System.out.println("El valor a pagar de la renta es de: "+valPagar);
		
		
	}

	@Override
	public void actualizar(Renta ren) {
		// TODO Auto-generated method stub
		this.renRepo.actualizar(ren);
	}

	@Override
	public Renta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.renRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.renRepo.eliminar(id);
	}
	


}
