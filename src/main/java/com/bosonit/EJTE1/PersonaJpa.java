package com.bosonit.EJTE1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaJpa extends JpaRepository<Persona, Long> {
    Optional<Persona> findByNombre(String nombre);
    Optional<Persona> findByCiudad(String ciudad);

}
