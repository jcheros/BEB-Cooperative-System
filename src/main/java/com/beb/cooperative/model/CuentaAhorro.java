package com.beb.cooperative.model;

import java.math.BigDecimal;

public class CuentaAhorro {
    private int id;
    private BigDecimal saldo;
    private BigDecimal tasaInteres;
    private int clienteId;

    public CuentaAhorro() {
    }

    public CuentaAhorro(int id, BigDecimal saldo, BigDecimal tasaInteres, int clienteId) {
        this.id = id;
        this.saldo = saldo;
        this.tasaInteres = tasaInteres;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
