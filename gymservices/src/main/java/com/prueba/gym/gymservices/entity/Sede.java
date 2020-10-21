package com.prueba.gym.gymservices.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Sede {
	
	@Id
	@GeneratedValue
	private Long id;
	private String sede;

	@ManyToOne(optional = false,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ciudad_id", nullable = false)
	private Ciudad ciudad;
	
    protected Sede() {
		
	}
    
    

	public Sede(String sede, Ciudad ciudad) {
		super();
		this.sede = sede;
		this.ciudad = ciudad;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
