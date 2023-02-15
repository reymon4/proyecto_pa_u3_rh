package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Hotel;
import com.example.demo.modelo.Habitacion;
import com.example.demo.service.IHabitacionSer;
import com.example.demo.service.IHotelSer;



@SpringBootApplication
public class ProyectoPaU3RhApplication implements CommandLineRunner {

	@Autowired
	private IHotelSer hotelSer;
	
	@Autowired
	private IHabitacionSer habitacionSer;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//LEFT Join sin parámetro - Hotel
		System.out.println("\n LEft Join-Hotel");
		List<Hotel> lista = this.hotelSer.buscarHotelOuterLeftJoin();
		for(Hotel h: lista) {
			System.out.println(h.getNombre());
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		System.out.println("\n Left Join-Habitación");
		//LEFT Join sin parámetro - Habitación
		
		List<Habitacion> lista2 = this.habitacionSer.buscarHabitacionOuterLeftJoin();
		for(Habitacion h: lista2) {
			System.out.println(h!=null? h.getNumero():null);
	
		}
	 
	
			System.out.println("\n Right Join-Habitación");
			//RIGHT Join sin parámetro - Habitación
			
			List<Habitacion> lista4 = this.habitacionSer.buscarHabitacionOuterRightJoin();
			for(Habitacion h: lista4) {
				System.out.println(h!=null? h.getNumero():null);
				System.out.println(h.getHotel());
			}
			

			//RIGHT Join sin parámetro - Hotel
				System.out.println("\n Right Join-hotel");
					List<Hotel> lista3 = this.hotelSer.buscarHotelOuterRightJoin();
					for(Hotel h: lista3) {
						System.out.println(h!=null? h.getNombre():null);
					}
					
			System.out.println("\n FETCH join -hotel");
			List<Hotel> lista5 = this.hotelSer.buscarHotelJoinFetch("VIP");
			for(Hotel h: lista5) {
				System.out.println(h!=null? h.getNombre():null);
			}
					
		 }
}

	
	
	
	
			
