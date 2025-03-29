package com.beb.cooperative.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CDT {
    private int id;
    private BigDecimal montoInvertido;
    private BigDecimal tasaInteres;
    private LocalDate fechaVencimiento;
    private int clienteId;

    public CDT() {
    }

    public CDT(int id, BigDecimal montoInvertido, BigDecimal tasaInteres, LocalDate fechaVencimiento, int clienteId) {
        this.id = id;
        this.montoInvertido = montoInvertido;
        this.tasaInteres = tasaInteres;
        this.fechaVencimiento = fechaVencimiento;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(BigDecimal montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
