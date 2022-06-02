package com.ingeneria.proyecto.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductoDto implements Serializable {
    private Long idProducto;
    private String nombre;
    private String precioUnidad;
    private String unidadMedida;
    private Long existencia;
    private String Descripcion;
    private Date fechaCreacion;
    private Date fechaVencimiento;
}
