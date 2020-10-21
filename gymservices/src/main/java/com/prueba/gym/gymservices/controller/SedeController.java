package com.prueba.gym.gymservices.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.prueba.gym.gymservices.entity.Sede;
import com.prueba.gym.gymservices.repositories.SedeRepository;


@RestController
public class SedeController {
	
	
	@Autowired
	private SedeRepository sedeRepository;
	

	@RequestMapping(method = RequestMethod.GET, path = "/prueba2")
	public String prueba() {
		return "prueba exitosa en Sede Controller";
	}
	
	@PostMapping("/users/{username}/sedes")
	public ResponseEntity<Void> createSede(@PathVariable String username, @RequestBody Sede sede){
		try {
			Sede sedeCreada = sedeRepository.save(sede);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sedeCreada.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconcistencia de Integridad referencial con la tabla ciudad", ex);
		}
		
	}
	

	

}
