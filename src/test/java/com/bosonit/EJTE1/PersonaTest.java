package com.bosonit.EJTE1;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonaTest {
    @Test
    public void crearPersona() {
        Persona persona = new Persona(1L,"Emar", "Burgos");
        Assertions.assertThat(persona.getId()).isEqualTo(1);
        Assertions.assertThat(persona.getNombre()).isEqualTo("Emar");
        Assertions.assertThat(persona.getCiudad()).isEqualTo("Burgos");
    }
}
