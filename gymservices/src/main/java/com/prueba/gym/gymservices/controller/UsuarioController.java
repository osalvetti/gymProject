package com.prueba.gym.gymservices.controller;

import java.net.URI;
import java.util.List;

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

import com.prueba.gym.gymservices.entity.Ciudad;
import com.prueba.gym.gymservices.entity.Usuario;
import com.prueba.gym.gymservices.repositories.CiudadRepository;
import com.prueba.gym.gymservices.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/prueba3")
	public String prueba() {
		return "prueba exitosa en Usuario Controller";
	}
	
	@PostMapping("/users/{username}/usuarios")
	public ResponseEntity<Void> createUsuasrio(@PathVariable String username, @RequestBody Usuario usuario){
		try {
			Usuario usuarioCreada = usuarioRepository.save(usuario);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(usuarioCreada.getId()).toUri();
			return ResponseEntity.created(uri).build();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconcistenci de Integridad referencial con la tabla Sede", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{username}/usuarios/{sedeId}")
	public List<Usuario> getUsuariosBySede(@PathVariable String username, @PathVariable String sedeId) {
		Long sede = Long.parseLong(sedeId);
		return usuarioRepository.getUsuarioBySede(sede);
	}

}
