package com.nisum.eval.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 377874620158527856L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPersona;
	
	@Column(name ="name", length=50)
	private String name;
	
	@Column(name ="email", length=50, unique = true)
	private String email;
	
	@Column(name ="password", length=50)
	private String password;
	
	
	
	@Column(name ="created")
	private Date created;
	
	@Column(name ="modified")
	private Date modified;
	
	@Column(name ="last_login")
	private Date last_login;
	
	@Column(name ="active")
	private boolean active;
	
	
	@Column(name ="token", length=50)
	private String token;
	
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//@GeneratedValue(generator = "uuid2")
	//@GenericGenerator(name = "uuid2", strategy = "uuid2")
	//@Column(columnDefinition = "BINARY(16)")
	private UUID uuid;
	
	
	
//	@OneToMany(mappedBy="persona", targetEntity=Telefono.class, cascade = CascadeType.ALL)
//	@JoinColumn (name="pt_fk", referencedColumnName = "idPersona")
//	private List<Telefono> phones;
	    
    public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "persona")
    private List<Telefono> phones;
	
	
	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
