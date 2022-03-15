package com.nisum.eval.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.eval.model.Persona;
import com.nisum.eval.model.Telefono;
import com.nisum.eval.repository.IPersonaRepo;
import com.nisum.eval.repository.ITelefonoRepo;
import com.nisum.eval.utils.ResponseJson;
import com.nisum.eval.utils.Validador;

@Service
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private IPersonaRepo personaRepo;
	
	//@Autowired
	//private ITelefonoRepo telefonoRepo;
	/**
	 * 
	 */
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		try {
			return personaRepo.findAll();
		
		}catch(Exception e) {
			return new ArrayList<Persona>();
		}
	}
	
	/**
	 * 
	 */
	public Persona save(Persona p) {
		// TODO Auto-generated method stub
		
		try {
			Persona nueva = personaRepo.save(p);
			/*if(nueva.getIdPersona()>0 ) {
				for(Telefono t: nueva.getPhones()) {
					t.setPersona(p);
					telefonoRepo.save(t);
				}
			}*/
			return nueva;
			
		}catch(org.springframework.dao.DataIntegrityViolationException emailEx) {
			/**
			 * Validacion Email unico
			 */
			System.out.println("UNIKE        **************   "+emailEx.toString());
		}catch (Exception ee) {
			System.out.println(ee.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Persona findById(int id) {
		try {
			Optional<Persona>  nueva = personaRepo.findById(id);
			if(nueva.isPresent()) {
				return nueva.get();
			}
			return null;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public boolean delete(Persona p){
		try {
			int id=p.getIdPersona();
			personaRepo.delete(p);
			if(personaRepo.existsById(id)) {
				return false;
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
}
