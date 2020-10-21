package com.prueba.gym.gymservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.gym.gymservices.entity.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Long>{

}
