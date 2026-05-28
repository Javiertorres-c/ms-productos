package com.Javier.ms_productos.repository;

import com.Javier.ms_productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByEstadoTrue();
}
