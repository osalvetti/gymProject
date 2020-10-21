package com.prueba.gym.gymservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.gym.gymservices.entity.Ciudad;
import com.prueba.gym.gymservices.entity.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long>{

}
