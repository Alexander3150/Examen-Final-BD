package com.umg.importaciones.service;

import com.umg.importaciones.entity.MovimientoInventario;
import java.util.List;

public interface MovimientoInventarioService {

    List<MovimientoInventario> findAll();

    MovimientoInventario findById(Integer id);

    MovimientoInventario registrarMovimiento(MovimientoInventario movimiento);

    void delete(Integer id);

    List<MovimientoInventario> listarPorProducto(Integer idProducto);

    List<MovimientoInventario> listarPorProveedor(Integer idProveedor);
}
