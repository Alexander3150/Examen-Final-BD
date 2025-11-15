package com.umg.importaciones.repository;

import com.umg.importaciones.entity.MovimientoInventario;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {

    List<MovimientoInventario> findByProductoIdProducto(Integer idProducto);

    List<MovimientoInventario> findByProveedorIdProveedor(Integer idProveedor);

    List<MovimientoInventario> findByFechaMovimientoBetween(LocalDateTime desde, LocalDateTime hasta);
}
