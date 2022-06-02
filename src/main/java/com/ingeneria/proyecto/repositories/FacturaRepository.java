package com.ingeneria.proyecto.repositories;

import com.ingeneria.proyecto.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}