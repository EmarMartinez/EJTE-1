package com.bosonit.EJTE1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonaJpaTest {

    @Autowired
    private PersonaJpa personaJpa;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        Persona persona = new Persona("Emar", "Burgos");

        personaJpa.save(persona);

        Assertions.assertThat(persona.getId()).isPositive();
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Persona persona = personaJpa.findById(1L).get();

        Assertions.assertThat(persona.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getEmployeeByCity(){

        Optional<Persona> optionalPersona = personaJpa.findByCiudad("Burgos");
        Assertions.assertThat(optionalPersona.get().getCiudad()).isEqualTo("Burgos");

    }

    @Test
    @Order(4)
    public void getListOfEmployeesTest(){

        List<Persona> personas = personaJpa.findAll();

        Assertions.assertThat(personas.size()).isPositive();

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Persona persona = personaJpa.findById(1L).get();

        persona.setCiudad("Logroño");

        Persona personaActualizada =  personaJpa.save(persona);

        Assertions.assertThat(personaActualizada.getCiudad()).isEqualTo("Logroño");

    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Persona persona = personaJpa.findById(1L).get();

        personaJpa.delete(persona);

        Persona personaNull = null;

        Optional<Persona> optionalPersona = personaJpa.findByNombre("Emar");

        if(optionalPersona.isPresent()){
            personaNull = optionalPersona.get();
        }

        Assertions.assertThat(personaNull).isNull();
    }


}
