package com.ingeneria.proyecto.managercliente.service;


import com.ingeneria.proyecto.entities.Cliente;
import com.ingeneria.proyecto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ServiceCliente {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ServiceCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Transactional(readOnly = true)
    public List<Cliente>listaClientes(){
        return clienteRepository.findAll();
    }
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente CrearCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }
    @Transactional
    public Cliente BuscarCLiente(Long idCLiente){
        return clienteRepository.findById(idCLiente).orElse(null);
    }
    @Transactional
    public void EliminarCliente(Long idCLiente){
         clienteRepository.deleteById(idCLiente);
    }
}
