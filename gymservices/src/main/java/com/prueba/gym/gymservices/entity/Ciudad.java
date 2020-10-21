package com.prueba.gym.gymservices.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue
	private Long id;
	private String cod;
	private String ciudad;
	
	@OneToMany(mappedBy="id",cascade = CascadeType.ALL)
    private List<Sede> sedes = new ArrayList<Sede>();
	
	protected Ciudad() {
		
	}
	
	public Ciudad(long id, String cod, String ciudad) {
		super();
		//this.id = id;
		this.cod = cod;
		this.ciudad = ciudad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public List<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
	
	
	

}
