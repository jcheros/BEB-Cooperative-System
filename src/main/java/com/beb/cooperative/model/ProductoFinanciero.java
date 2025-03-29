package com.beb.cooperative.model;

import java.math.BigDecimal;

public class ProductoFinanciero {
    private int id;
    private String nombre; // Ej: "Crédito Personal", "Inversión a 6 meses"
    private String descripcion;
    private BigDecimal tasa;

    public ProductoFinanciero() {
    }

    public ProductoFinanciero(int id, String nombre, String descripcion, BigDecimal tasa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tasa = tasa;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }
}
