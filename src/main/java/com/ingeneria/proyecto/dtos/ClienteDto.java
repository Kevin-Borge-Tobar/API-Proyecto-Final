package com.ingeneria.proyecto.dtos;


import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ClienteDto implements Serializable {
    private Long idCliente;
    private String nit;
    private String nombre;
    private String apellido;
    private Date fechaCreacion;
    private String email;
    private String telefono;
    private List<FacturaDto> facturas;
}
