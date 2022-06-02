package com.ingeneria.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;
    private String descripcion;
    private String observacion;
    //many corresponde a a la clase que contiene la relacion y one corresponde la la contraparte
    //establecemos el joincolumn
    @JsonIgnoreProperties({"facturas", "hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    //una factura muchos items
    //establecemos el fetch en carga perezosa para evitar que se cargue completo el json
    //y el cascade en all por si eliminamos una factura se borren todos los items relacionados a la factura
    // y como no tenemos la relacion invesa indicamos el joincolum
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "facturas_id_factura")
    private List<ItemFactura> items;

}
