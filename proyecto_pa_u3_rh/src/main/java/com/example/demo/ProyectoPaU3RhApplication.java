package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Hotel;
import com.example.demo.modelo.Habitacion;

import com.example.demo.service.IHotelSer;



@SpringBootApplication
public class ProyectoPaU3RhApplication implements CommandLineRunner {

	@Autowired
	private IHotelSer hotelSer;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LEFT JOIN");
		System.out.println("\n");
		List<Hotel> l2_h =hotelSer.buscarHotelOuterLeftJoin("VIP");
		for (Hotel h: l2_h) {
			System.out.println(h.getNombre());
			for (Habitacion ha: h.getHabitaciones()) {
				System.out.println("Las habitaciones de: "+h.getNombre()+"  son: "+ha.getNumero());
			}
		}

		System.out.println("Right JOIN");
		System.out.println("\n");
		List<Hotel> l3_h =hotelSer.buscarHotelOuterRightJoin("VIP");
		l3_h.forEach(System.out::println);
		for (Hotel h: l3_h) {
			//System.out.println(h.getNombre());
			/*if(h.getHabitaciones()!=null) {
				for (Habitacion ha: h.getHabitaciones()) {
					System.out.println("Las habitaciones de: "+h.getNombre()+"  son: "+ha.getNumero());
				}
			}*/

		}

		/*
		List<Hotel> l2_h =hotelService.buscarHotelOuterRightJoin("VIP");
		l2_h.forEach(System.out::println);
		List<Hotel> l3_h =hotelService.buscarHotelOuterLeftJoin("VIP");
		l3_h.forEach(System.out::println);
		List<Hotel> l4_h =hotelService.buscarHotelOuterFullJoin("VIP");
		l4_h.forEach(System.out::println);
		List<Hotel> l5_h =hotelService.buscarHotelJoinFetch("VIP");
		l5_h.forEach(System.out::println);
		*/

		List<Hotel> l1_h =hotelSer.buscarHotelInnerJoin("VIP");
		l1_h.forEach(System.out::println);
		System.out.println("\n");
		System.out.println("JOIN MEJORADO-MISMA FUNCIONALIDAD"); //De lo explicado anteriormente
		for (Hotel h: l1_h) {
			System.out.println(h.getNombre());
			for (Habitacion ha: h.getHabitaciones()) {
				System.out.println("Las habitaciones de: "+h.getNombre()+"  son: "+ha.getNumero());

}
		}
	}}
	
			
