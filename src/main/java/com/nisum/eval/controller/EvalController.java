package com.nisum.eval.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.eval.model.Persona;
import com.nisum.eval.service.PersonaService;
import com.nisum.eval.utils.ResponseJson;
import com.nisum.eval.utils.Validador;


@RestController
@RequestMapping(path="/rest/evaluacion/")
public class EvalController {
	
	private static final String RESPUESTA_OK = "Proceso OK.";
	private static final String RESPUESTA_EXISTE_CORREO = "El correo existe.";
	private static final String RESPUESTA_CORREO_INVALIDO = "Formato de correo no valido.";
	private static final String RESPUESTA_ERROR_CONTRASEÑA = "Contraseña no valida";
	private static final String VALIDACION_REGEX = "evaluacion.nisum.regex.password";
	@Autowired 
	private PersonaService personaService;
	
	@Value("${" + VALIDACION_REGEX + "}")
    private String regexPassord;
	
	
	
	public String getRegexPassord() {
		return regexPassord;
	}


	public void setRegexPassord(String regexPassord) {
		this.regexPassord = regexPassord;
	}


	@PostMapping
	public ResponseEntity<ResponseJson> create(@RequestBody Persona per){
		ResponseJson respuesta = new ResponseJson();		
    	ResponseEntity<ResponseJson> response = null;
		
    	//Validacion del correo electronico
		if(!Validador.valCorreo(per.getEmail())) {
			respuesta.setMessage(RESPUESTA_CORREO_INVALIDO);
			response = new ResponseEntity<ResponseJson>(respuesta, HttpStatus.OK);
			return response;
    	}
		
		
		//Validacion de password		
	    if(!Validador.valPass(per.getPassword(), regexPassord)) {
	    	respuesta.setMessage(RESPUESTA_ERROR_CONTRASEÑA);
			response = new ResponseEntity<ResponseJson>(respuesta, HttpStatus.OK);
			return response;
	    }
	    
	    //Se deben guardar los datos
	    per.setCreated(new Date());
	    per.setModified(new Date());
	    per.setLast_login(new Date());
	    
	    //Set UUId
	    UUID uuid = UUID.fromString("84cff9ea-de0f-4841-8645-58620adf49b2");
	    per.setUuid(uuid);
	    	    
	    per.setActive(true);
	    
	    Persona p = personaService.save(per);
	    
	    //Validacion email unico
	    if(p==null) {
	    	respuesta.setMessage(RESPUESTA_EXISTE_CORREO);
			response = new ResponseEntity<ResponseJson>(respuesta, HttpStatus.OK);
			return response;
	    }
	    
	    //Exito!
	    respuesta.setMessage(RESPUESTA_OK);
		response = new ResponseEntity<ResponseJson>(respuesta, HttpStatus.CREATED);
		return response;
	    		
		//return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(per));
	}
	
	
	@GetMapping
	public List<Persona> buscarTodos(){
		
    	
		Iterable<Persona> personas = personaService.findAll();
		List<Persona> result = new ArrayList<Persona>();
		personas.forEach(result::add);
		
		if(result!=null && !result.isEmpty()  ) {	    	
			return result;
	    }
		
		
		
		return new ArrayList<Persona>(); 
	}
	
	@GetMapping("/{personaId}")
	public Persona buscarId(@PathVariable Integer personaId){
		    	
		Persona persona = personaService.findById(personaId);
		
		if(persona!=null  ) {	    	
			return persona;
	    }
		
		
		return new Persona(); 
	}
	
	

	
}
