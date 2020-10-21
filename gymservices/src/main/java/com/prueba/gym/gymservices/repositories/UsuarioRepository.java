package com.prueba.gym.gymservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.gym.gymservices.entity.Ciudad;
import com.prueba.gym.gymservices.entity.Sede;
import com.prueba.gym.gymservices.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	@Query("SELECT us FROM Usuario us WHERE us.sede.id = :sedeId")
	List<Usuario> getUsuarioBySede(@Param("sedeId") Long sedeId);

}
