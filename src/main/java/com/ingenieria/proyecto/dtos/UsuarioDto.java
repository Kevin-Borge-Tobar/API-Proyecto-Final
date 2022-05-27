package com.ingenieria.proyecto.dtos;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDto implements Serializable {
    private Long id;
    private String email;
    private String password;
}
