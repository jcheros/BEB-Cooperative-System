package com.beb.cooperative.model;

public class Asesor {
    private int id;
    private String nombre;
    private String especializacion;

    public Asesor() {
    }

    public Asesor(int id, String nombre, String especializacion) {
        this.id = id;
        this.nombre = nombre;
        this.especializacion = especializacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
}
