package com.ingeneria.proyecto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nit;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    private  String email;
    private String telefono;

    //Especifica la parte contraria de el cliente en este caso un cliente puede tener muchas facturas
    //de tipo carga perezosa
    //y se establece en la contraparte que estara mappeado en el atributo llamando cliente
    //y se configura que cuando se elimine un cliente elimine al cliente y si se guarda a un cliente con varias facturas  primero
    //se guarda al cliente
    @JsonIgnoreProperties({"cliente","hibernateLazyInitializer", "handler"})
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;
}