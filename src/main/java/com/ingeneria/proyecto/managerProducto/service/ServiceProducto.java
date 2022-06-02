package com.ingeneria.proyecto.managerProducto.service;

import com.ingeneria.proyecto.entities.Cliente;
import com.ingeneria.proyecto.entities.Producto;
import com.ingeneria.proyecto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceProducto {

    private final ProductoRepository productoRepository;

    @Autowired
    public ServiceProducto(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listaProductos(){
        return  productoRepository.findAll();
    }
    @Transactional()
    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }
    @Transactional(readOnly = true)
    public Producto BuscarProducto(Long idProducto){
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Transactional
    public void EliminarProducto(Long idProducto){
        productoRepository.deleteById(idProducto);
    }
}
