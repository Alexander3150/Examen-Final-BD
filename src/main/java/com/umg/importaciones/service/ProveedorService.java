package com.umg.importaciones.service;

import com.umg.importaciones.entity.Proveedor;
import java.util.List;

public interface ProveedorService {

    List<Proveedor> findAll();

    Proveedor findById(Integer id);

    Proveedor save(Proveedor proveedor);

    void delete(Integer id);
}
