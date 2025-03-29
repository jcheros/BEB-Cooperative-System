package com.beb.cooperative.model;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private int asesorId;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String dni, int asesorId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.asesorId = asesorId;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAsesorId() {
        return asesorId;
    }

    public void setAsesorId(int asesorId) {
        this.asesorId = asesorId;
    }
}
