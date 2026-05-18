package com.Javier.ms_productos.service;

import com.Javier.ms_productos.dto.ProductoRequest;
import com.Javier.ms_productos.dto.ProductoResponse;
import com.Javier.ms_productos.entity.Producto;
import com.Javier.ms_productos.exception.ProductoNotFoundException;
import com.Javier.ms_productos.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;

    @Override
    public ProductoResponse crear(ProductoRequest req) {

        Producto p = Producto.builder()
                .nombre(req.nombre())
                .descripcion(req.descripcion())
                .precio(req.precio())
                .stock(req.stock())
                .estado(true)
                .fechaCreacion(LocalDateTime.now())
                .build();

        return toResponse(repo.save(p));
    }

    @Override
    public List<ProductoResponse> listar() {

        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ProductoResponse obtener(Long id) {
        return toResponse(buscarProducto(id));
    }

    @Override
    public ProductoResponse actualizar(Long id, ProductoRequest req) {

        Producto p = buscarProducto(id);

        p.setNombre(req.nombre());
        p.setDescripcion(req.descripcion());
        p.setPrecio(req.precio());
        p.setStock(req.stock());
        p.setEstado(true);

        return toResponse(repo.save(p));
    }

    @Override
    public void eliminar(Long id) {

        Producto p = buscarProducto(id);

        p.setEstado(false);

        repo.save(p);
    }

    private Producto buscarProducto(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ProductoNotFoundException(
                                "No existe un producto con el ID " + id
                        )
                );
    }

    private ProductoResponse toResponse(Producto p) {

        return new ProductoResponse(
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getStock(),
                p.getEstado(),
                p.getFechaCreacion()
        );
    }
}