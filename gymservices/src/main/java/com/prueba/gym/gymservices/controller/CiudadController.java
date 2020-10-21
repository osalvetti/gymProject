package com.prueba.gym.gymservices.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prueba.gym.gymservices.entity.Ciudad;
import com.prueba.gym.gymservices.repositories.CiudadRepository;

@RestController
@CrossOrigin(origins="http:localhost:4200")
public class CiudadController {
	
	
	@Autowired	
	private CiudadRepository ciudadRepository;
	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/prueba1")
	public String prueba() {
		return "prueba exitosa en Ciudad Controller";
	}
	
	@PostMapping("/users/{username}/ciudades")
	public ResponseEntity<Void> createCiudad(@PathVariable String username, @RequestBody Ciudad ciudad){
		
		Ciudad ciudadCreada = ciudadRepository.save(ciudad);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(ciudadCreada.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
