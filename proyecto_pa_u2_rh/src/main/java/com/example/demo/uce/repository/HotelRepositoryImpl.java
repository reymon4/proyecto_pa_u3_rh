package com.example.demo.uce.repository;

import org.springframework.stereotype.Repository;


import com.example.demo.uce.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	
	@PersistenceContext //Anotación para interactuar con la BD
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
		
	}
	//Este método es solo cuando necesito la entidad de Hotel
	@Override
	public Hotel buscarLigero(Integer id) {
		// TODO Auto-generated method stub
		
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel h = this.buscar(id);
		this.entityManager.remove(h);
		
	}

	@Override
	//Este método buscar me sirve cuando necesito las dos entidades: Hotel y habitaciones
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.entityManager.find(Hotel.class, id);
		//Con el Size el framework identifica que vamos a usar las habitaciones
		hotel.getHabitaciones().size();
		return hotel;
	}

}
