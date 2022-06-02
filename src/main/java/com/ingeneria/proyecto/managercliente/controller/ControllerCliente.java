package com.ingeneria.proyecto.managercliente.controller;
import com.ingeneria.proyecto.dtos.ClienteDto;
import com.ingeneria.proyecto.entities.Cliente;
import com.ingeneria.proyecto.managercliente.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {
    private final ServiceCliente serviceCliente;

    @Autowired
    public ControllerCliente(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }

    @GetMapping(value = "/lista")
    public List<Cliente>listadoClientes() {
        return serviceCliente.listaClientes();
    }
    
    @GetMapping(value = "/{idCliente}")
    public Cliente verCliente(@PathVariable Long idCliente) {
        return serviceCliente.BuscarCLiente(idCliente);
    }
    
    @PostMapping(value = "/crear")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        ResponseEntity<Cliente> ok = (ResponseEntity<Cliente>) ResponseEntity.ok(serviceCliente.CrearCliente(cliente));
        return ok;
    }
    @PutMapping(value = "/actualizar/{idCliente}")
    public ResponseEntity<Cliente> ActualizarCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        Cliente clienteActual= serviceCliente.BuscarCLiente(idCliente);
        clienteActual.setNit(cliente.getNit());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setTelefono(cliente.getTelefono());
        clienteActual.setEmail(cliente.getEmail());
        ResponseEntity<Cliente> ok = (ResponseEntity<Cliente>) ResponseEntity.ok(serviceCliente.CrearCliente(clienteActual));
        return ok;
    }
    @DeleteMapping(value = "/eliminar/{idCliente}")
    public void EliminarCliente(@PathVariable Long idCliente){
        serviceCliente.EliminarCliente(idCliente);
    }
}
