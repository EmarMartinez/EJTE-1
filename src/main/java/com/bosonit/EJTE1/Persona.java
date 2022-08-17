package com.bosonit.EJTE1;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity


public class Persona {
    @Id
    @GeneratedValue
    long id;
    String nombre;
    String ciudad;

    public Persona(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    public Persona(Long id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    public Persona() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
}
