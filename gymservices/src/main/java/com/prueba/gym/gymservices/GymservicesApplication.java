package com.prueba.gym.gymservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@SpringBootApplication
public class GymservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymservicesApplication.class, args);
	}

}
