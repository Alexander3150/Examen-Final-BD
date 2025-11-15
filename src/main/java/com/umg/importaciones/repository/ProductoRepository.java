package com.umg.importaciones.repository;

import com.umg.importaciones.entity.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByNombreIgnoreCase(String nombre);
}
