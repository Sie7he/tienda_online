package com.bazar.service;

import com.bazar.model.Cliente;
import com.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAllByEstadoTrue();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepository.findByEstadoTrueAndId(id).orElse(null);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
       return this.saveCliente(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.desactiveCliente(id);
    }
}
