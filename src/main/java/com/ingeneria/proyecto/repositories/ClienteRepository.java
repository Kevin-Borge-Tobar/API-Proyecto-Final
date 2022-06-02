package com.ingeneria.proyecto.repositories;


import com.ingeneria.proyecto.entities.Cliente;
import com.ingeneria.proyecto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}