package com.Javier.ms_productos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductoResponse(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer stock,
        Boolean estado,
        LocalDateTime fechaCreacion
) {}
