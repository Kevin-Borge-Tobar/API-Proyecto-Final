package com.ingeneria.proyecto.repositories;

import com.ingeneria.proyecto.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto, Long> {
}
