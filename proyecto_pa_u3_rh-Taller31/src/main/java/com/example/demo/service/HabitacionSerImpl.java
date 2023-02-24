package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.repository.IHabitacionRepo;

@Service
public class HabitacionSerImpl implements IHabitacionSer{

	@Autowired
	private IHabitacionRepo habitacionRepo;
	@Override
	public List<Habitacion> buscarHabitacionOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.habitacionRepo.buscarHabitacionOuterRightJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.habitacionRepo.buscarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterFullJoin() {
		// TODO Auto-generated method stub
		return null;
	}

}
