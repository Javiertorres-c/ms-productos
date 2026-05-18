package com.Javier.ms_productos.service;

import com.Javier.ms_productos.dto.ProductoRequest;
import com.Javier.ms_productos.dto.ProductoResponse;

import java.util.List;

public interface ProductoService {

    ProductoResponse crear(ProductoRequest req);

    List<ProductoResponse> listar();

    ProductoResponse obtener(Long id);

    ProductoResponse actualizar(Long id, ProductoRequest req);

    void eliminar(Long id);
}