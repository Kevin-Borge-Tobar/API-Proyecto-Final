package com.ingenieria.proyecto.repositories;

import com.ingenieria.proyecto.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto, Long> {
}
