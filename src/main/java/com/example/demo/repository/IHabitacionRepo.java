package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHabitacionRepo {
	

	public List<Habitacion> buscarHabitacionOuterRightJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterFullJoin();

}
