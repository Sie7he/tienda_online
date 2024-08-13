package com.bazar.controller;

import com.bazar.model.Cliente;
import com.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/clientes")
    Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }
}
