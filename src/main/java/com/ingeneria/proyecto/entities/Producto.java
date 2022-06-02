package com.ingeneria.proyecto.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProducto")
    private Long idProducto;
    private String nombre;
    @Column(name = "precio_unidad")
    private String  precioUnidad;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    private Long existencia;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date  fechaVencimiento;


}
