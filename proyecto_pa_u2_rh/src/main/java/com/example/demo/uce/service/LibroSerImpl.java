package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.modelo.Libro;
import com.example.demo.uce.repository.ILibroRepo;

@Service
public class LibroSerImpl implements ILibroSer{

	@Autowired
	private ILibroRepo libroRepo;
	
	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		
	
		this.libroRepo.insertar(libro);
}
}
