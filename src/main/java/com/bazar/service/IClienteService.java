package com.bazar.service;

import com.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> getClientes();

    Cliente saveCliente(Cliente cliente);

    Cliente findCliente(Long id);

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(Long id);

}
