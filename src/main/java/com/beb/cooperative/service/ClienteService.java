package com.beb.cooperative.service;

import com.beb.cooperative.model.Cliente;
import com.beb.cooperative.repository.AsesorRepository;
import com.beb.cooperative.repository.ClienteRepository;
import java.util.List;

public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final AsesorRepository asesorRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.asesorRepository = new AsesorRepository();
    }

    // Crear cliente con validaciones
    public void crearCliente(Cliente cliente) throws IllegalArgumentException {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es requerido");
        }
        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del cliente es requerido");
        }
        if (cliente.getDni() == null || !cliente.getDni().matches("\\d+")) {
            throw new IllegalArgumentException("El DNI debe ser numérico");
        }
        if (asesorRepository.findAll().stream().noneMatch(a -> a.getId() == cliente.getAsesorId())) {
            throw new IllegalArgumentException("El asesor asignado no existe");
        }

        clienteRepository.save(cliente);
    }

    // Obtener cliente por ID
    public Cliente buscarClientePorId(int id) {
        return clienteRepository.findById(id);
    }
    
    // Obtener cliente por DNI
    public Cliente buscarClientePorDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    // Listar todos los clientes
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }
}
