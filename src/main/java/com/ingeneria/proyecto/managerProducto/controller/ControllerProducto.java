package com.ingeneria.proyecto.managerProducto.controller;
import com.ingeneria.proyecto.entities.Producto;
import com.ingeneria.proyecto.managerProducto.service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/productos")
@RestController
public class ControllerProducto {

    private final ServiceProducto serviceProducto;

    @Autowired
    public ControllerProducto(ServiceProducto serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

    @GetMapping("/lista")
    public  List<Producto> listaProductos(){

        return serviceProducto.listaProductos();
    }

    @GetMapping(value = "/{idProducto}")
    public Producto verCliente(@PathVariable Long idProducto) {
        return serviceProducto.BuscarProducto(idProducto);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        ResponseEntity<Producto> ok = (ResponseEntity<Producto>) ResponseEntity.ok(serviceProducto.crearProducto(producto));
        return ok;
    }
    @PutMapping(value = "/actualizar/{idCliente}")
    public ResponseEntity<Producto> ActualizarCliente(@PathVariable Long idProducto, @RequestBody Producto producto) {
        Producto productoActual= serviceProducto.BuscarProducto(idProducto);

        //solo se permite actualizar estos campos por el momento pero se pueden modificar a conveniencia del usuario
        productoActual.setNombre(producto.getNombre());
        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setPrecioUnidad(producto.getPrecioUnidad());
        ResponseEntity<Producto> ok = (ResponseEntity<Producto>) ResponseEntity.ok(serviceProducto.crearProducto(productoActual));
        return ok;
    }
    @DeleteMapping(value = "/eliminar/{idCliente}")
    public void EliminarCliente(@PathVariable Long idProducto){
        serviceProducto.EliminarProducto(idProducto);
    }
}
