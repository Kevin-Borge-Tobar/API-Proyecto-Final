package com.ingeneria.proyecto.managerFactura.service;

import com.ingeneria.proyecto.entities.Factura;
import com.ingeneria.proyecto.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceFactura {
    private FacturaRepository facturaRepository;

    @Autowired
    public ServiceFactura(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @Transactional(readOnly = true)
    public Factura buscarFactura(Long idFactura){
        return  facturaRepository.findById(idFactura).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Factura>ListaFacturas(){
        return  facturaRepository.findAll();
    }


    @Transactional
    public Factura crearFactura(Factura factura){
       return facturaRepository.save(factura);
    }

    @Transactional
    public void eliminarFactura(Long idFactura){
        facturaRepository.deleteById(idFactura);
    }
}
