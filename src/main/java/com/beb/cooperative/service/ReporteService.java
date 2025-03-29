package com.beb.cooperative.service;

import com.beb.cooperative.model.Cliente;
import com.beb.cooperative.model.Transaccion;
import com.beb.cooperative.repository.ClienteRepository;
import com.beb.cooperative.repository.TransaccionRepository;
import java.time.LocalDate;
import java.util.List;

public class ReporteService {
    private final TransaccionRepository transaccionRepository;
    private final ClienteRepository clienteRepository;

    public ReporteService() {
        this.transaccionRepository = new TransaccionRepository();
        this.clienteRepository = new ClienteRepository();
    }

    // Generar reporte de transacciones por cliente y fecha
    public List<Transaccion> generarReporteTransacciones(int clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
        Cliente cliente = clienteRepository.findById(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no existe");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("Rango de fechas inválido");
        }

        return transaccionRepository.findByClienteAndDate(clienteId, fechaInicio, fechaFin);
    }
}
