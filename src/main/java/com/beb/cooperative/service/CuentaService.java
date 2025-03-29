package com.beb.cooperative.service;

import com.beb.cooperative.model.CuentaAhorro;
import com.beb.cooperative.repository.ClienteRepository;
import com.beb.cooperative.repository.CuentaRepository;
import java.math.BigDecimal;

public class CuentaService {
    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    public CuentaService() {
        this.cuentaRepository = new CuentaRepository();
        this.clienteRepository = new ClienteRepository();
    }

    // Abrir cuenta de ahorro
    public void abrirCuentaAhorro(CuentaAhorro cuenta) {
        if (clienteRepository.findById(cuenta.getClienteId()) == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        if (cuenta.getTasaInteres().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser mayor a 0");
        }
        cuentaRepository.saveCuentaAhorro(cuenta);
    }

    // Consignar a una cuenta
    public void consignar(int cuentaId, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        CuentaAhorro cuenta = cuentaRepository.findCuentaAhorroById(cuentaId);
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        cuentaRepository.actualizarCuenta(cuenta); // Método a implementar en CuentaRepository
    }
}
