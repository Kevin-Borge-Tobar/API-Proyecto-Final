package com.ingenieria.proyecto.entities;

import com.ingenieria.proyecto.entities.Cliente;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date  fechaCreacion;
    //many corresponde a a la clase que contiene la relacion y one corresponde la la contraparte
    //establecemos el joincolumn
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;

    //una factura muchos items
    //establecemos el fetch en carga perezosa para evitar que se cargue completo el json
    //y el cascade en all por si eliminamos una factura se borren todos los items relacionados a la factura
    // y como no tenemos la relacion invesa indicamos el joincolum
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id_factura")
    private List<ItemFactura> items;

    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date();
    }

}
