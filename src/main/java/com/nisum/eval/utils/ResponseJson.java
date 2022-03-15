package com.nisum.eval.utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseJson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6051341696627084858L;
	private String mensaje;
	
	public ResponseJson() {
		super();
	}

	public ResponseJson( String mensaje) {
		this.setMessage(mensaje);
	}

	public String getMessage() {
		return mensaje;
	}

	public void setMessage(String mensaje) {
		this.mensaje = mensaje;
	}
}
