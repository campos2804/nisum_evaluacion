package com.nisum.eval.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefono implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2573978979482254203L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPhone;
	
	@Column(name ="name")
	private int number;
	
	@Column(name ="citycode")
	private int citycode;
	
	@Column(name ="countrycode")
	private int countrycode;

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCitycode() {
		return citycode;
	}

	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	
	
	 @ManyToOne(fetch=FetchType.LAZY, optional = true)
	 @JoinColumn(name = "idPersona",  updatable = false)
	 private Persona persona;
	

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + citycode;
		result = prime * result + countrycode;
		result = prime * result + idPhone;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		if (citycode != other.citycode)
			return false;
		if (countrycode != other.countrycode)
			return false;
		if (idPhone != other.idPhone)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefono [idPhone=" + idPhone + ", number=" + number + ", citycode=" + citycode + ", countrycode="
				+ countrycode + "]";
	}
	
	
	
}
