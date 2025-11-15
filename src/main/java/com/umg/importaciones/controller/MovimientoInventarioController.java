package com.umg.importaciones.controller;

import com.umg.importaciones.entity.MovimientoInventario;
import com.umg.importaciones.service.MovimientoInventarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoInventarioController {

    private final MovimientoInventarioService movimientoInventarioService;

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listar() {
        return ResponseEntity.ok(movimientoInventarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> obtener(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(movimientoInventarioService.findById(id));
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> registrar(@RequestBody MovimientoInventario movimiento) {
        MovimientoInventario guardado = movimientoInventarioService.registrarMovimiento(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<MovimientoInventario>> listarPorProducto(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(movimientoInventarioService.listarPorProducto(idProducto));
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<MovimientoInventario>> listarPorProveedor(@PathVariable Integer idProveedor) {
        return ResponseEntity.ok(movimientoInventarioService.listarPorProveedor(idProveedor));
    }
}
