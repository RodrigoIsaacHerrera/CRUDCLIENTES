package com.tata.duoc.HerreraRodrigo.modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientesDAO extends JpaRepository<ClientesVO, String>{

	Optional<ClientesVO> findByNombres(String nombre);

}
