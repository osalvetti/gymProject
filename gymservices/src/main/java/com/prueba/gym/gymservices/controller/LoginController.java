
package com.prueba.gym.gymservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/prueba")
	public String prueba() {
		return "prueba exitosa";
	}

}
