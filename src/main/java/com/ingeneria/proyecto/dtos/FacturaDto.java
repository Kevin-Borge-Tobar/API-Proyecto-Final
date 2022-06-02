package com.ingeneria.proyecto.dtos;

import com.ingeneria.proyecto.entities.Factura;
import com.ingeneria.proyecto.entities.ItemFactura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacturaDto implements Serializable {
    private Long id;
    private String descripcion;
    private String observacion;
    private Date fechaCreacion;
    private ClienteDto cliente;
    private List<ItemFacturaDto> facturas;
}
