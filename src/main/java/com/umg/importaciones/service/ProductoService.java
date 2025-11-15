package com.umg.importaciones.service;

import com.umg.importaciones.entity.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Integer id);

    Producto save(Producto producto);

    void delete(Integer id);
}
