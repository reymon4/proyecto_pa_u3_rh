package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub+


		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha "
				+ "WHERE ha.tipo=:datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);

		List <Hotel> listaHoteles=myQuery.getResultList();
		//BAJO DEMANDA
		for (Hotel h:listaHoteles) {
			List<Habitacion> listaTMP=new ArrayList<>();
			for(Habitacion ha:h.getHabitaciones()) {
				if(ha.getTipo().equals(tipoHabitacion)) {
					listaTMP.add(ha);
				}
			}
			h.setHabitaciones(listaTMP);

		}


		return listaHoteles;
	}


	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha "
				+ "WHERE ha.tipo=:datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);

		List <Hotel> listaHoteles=myQuery.getResultList();

		/*for (Hotel h:listaHoteles) {
			h.getHabitaciones().size();
		}*/

		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha "
				+ "WHERE ha.tipo=:datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);

		List <Hotel> listaHoteles=myQuery.getResultList();
		for (Hotel h:listaHoteles) {
			h.getHabitaciones().size();
		}

		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}
}
