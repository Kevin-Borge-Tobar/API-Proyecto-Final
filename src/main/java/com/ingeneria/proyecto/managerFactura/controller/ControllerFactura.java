package com.ingeneria.proyecto.managerFactura.controller;
import com.ingeneria.proyecto.entities.Factura;
import com.ingeneria.proyecto.managerFactura.service.ServiceFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/facturas")
public class ControllerFactura {
    private  final ServiceFactura serviceFactura;
    @Autowired
    public ControllerFactura( ServiceFactura serviceFactura) {
        this.serviceFactura = serviceFactura;
    }
    @GetMapping("/")
    public List<Factura> listaFacturas() {
        return serviceFactura.ListaFacturas();
    }
    @GetMapping("/ver/{idFactura}")
    public Factura buscarFactura(@PathVariable Long idFactura) {
         return serviceFactura.buscarFactura(idFactura);
    }
    @PostMapping("/crear")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Factura crearFactura(@RequestBody Factura factura){
       return serviceFactura.crearFactura(factura);
    }

}
