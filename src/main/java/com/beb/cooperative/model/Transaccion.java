package com.beb.cooperative.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaccion {
    private int id;
    private BigDecimal monto;
    private String tipo; // Ej: "CONSIGNACION", "RETIRO"
    private LocalDateTime fecha;
    private int cuentaId;

    public Transaccion() {
    }

    public Transaccion(int id, BigDecimal monto, String tipo, LocalDateTime fecha, int cuentaId) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.cuentaId = cuentaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }
}
