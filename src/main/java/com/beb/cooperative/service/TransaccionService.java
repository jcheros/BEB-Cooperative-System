package com.beb.cooperative.service;

import com.beb.cooperative.model.CuentaAhorro;
import com.beb.cooperative.model.Transaccion;
import com.beb.cooperative.repository.CuentaRepository;
import com.beb.cooperative.repository.TransaccionRepository;

public class TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public TransaccionService() {
        this.transaccionRepository = new TransaccionRepository();
        this.cuentaRepository = new CuentaRepository();
    }

    // Registrar transacción con validación de saldo
    public void registrarTransaccion(Transaccion transaccion) {
        CuentaAhorro cuenta = cuentaRepository.findCuentaAhorroById(transaccion.getCuentaId());
        
        if (cuenta == null) {
            throw new IllegalArgumentException("Cuenta no encontrada");
        }
        if ("RETIRO".equals(transaccion.getTipo()) && cuenta.getSaldo().compareTo(transaccion.getMonto()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        transaccionRepository.save(transaccion);
        actualizarSaldoCuenta(cuenta, transaccion);
    }

    private void actualizarSaldoCuenta(CuentaAhorro cuenta, Transaccion transaccion) {
        if ("CONSIGNACION".equals(transaccion.getTipo())) {
            cuenta.setSaldo(cuenta.getSaldo().add(transaccion.getMonto()));
        } else {
            cuenta.setSaldo(cuenta.getSaldo().subtract(transaccion.getMonto()));
        }
        cuentaRepository.actualizarCuenta(cuenta);
    }
}
