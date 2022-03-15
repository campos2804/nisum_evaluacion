package com.nisum.eval.service;
import com.nisum.eval.model.Persona;

public interface PersonaService {
	public Iterable<Persona> findAll();
	public Persona save(Persona p);
	public Persona findById(int id);
	public boolean delete(Persona p);
	
}
