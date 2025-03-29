package com.beb.cooperative.model;

import java.math.BigDecimal;

public class CuentaCorriente {
    private int id;
    private BigDecimal saldo;
    private int clienteId;

    public CuentaCorriente() {
    }

    public CuentaCorriente(int id, BigDecimal saldo, int clienteId) {
        this.id = id;
        this.saldo = saldo;
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
