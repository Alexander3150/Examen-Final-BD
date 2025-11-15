package com.umg.importaciones.service.impl;

import com.umg.importaciones.entity.MovimientoInventario;
import com.umg.importaciones.entity.Producto;
import com.umg.importaciones.enums.TipoMovimiento;
import com.umg.importaciones.repository.MovimientoInventarioRepository;
import com.umg.importaciones.repository.ProductoRepository;
import com.umg.importaciones.service.MovimientoInventarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

    private final MovimientoInventarioRepository movimientoInventarioRepository;
    private final ProductoRepository productoRepository;

    @Override
    public List<MovimientoInventario> findAll() {
        return movimientoInventarioRepository.findAll();
    }

    @Override
    public MovimientoInventario findById(Integer id) {
        return movimientoInventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }

    @Override
    public MovimientoInventario registrarMovimiento(MovimientoInventario movimiento) {
        if (movimiento.getProducto() == null || movimiento.getProducto().getIdProducto() == null) {
            throw new RuntimeException("Producto requerido");
        }

        Producto producto = productoRepository.findById(movimiento.getProducto().getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Integer cantidad = movimiento.getCantidad();
        if (cantidad == null || cantidad <= 0) {
            throw new RuntimeException("Cantidad inválida");
        }

        TipoMovimiento tipo = movimiento.getTipoMovimiento();
        if (tipo == null) {
            throw new RuntimeException("Tipo de movimiento requerido");
        }

        int stockActual = producto.getStockActual() == null ? 0 : producto.getStockActual();

        if (tipo == TipoMovimiento.ENTRADA) {
            producto.setStockActual(stockActual + cantidad);
        } else if (tipo == TipoMovimiento.SALIDA) {
            int nuevoStock = stockActual - cantidad;
            if (nuevoStock < 0) {
                throw new RuntimeException("Stock insuficiente");
            }
            producto.setStockActual(nuevoStock);
        } else {
            throw new RuntimeException("Tipo de movimiento no soportado");
        }

        Producto productoActualizado = productoRepository.save(producto);
        movimiento.setProducto(productoActualizado);

        return movimientoInventarioRepository.save(movimiento);
    }

    @Override
    public void delete(Integer id) {
        MovimientoInventario movimiento = findById(id);
        movimientoInventarioRepository.delete(movimiento);
    }

    @Override
    public List<MovimientoInventario> listarPorProducto(Integer idProducto) {
        return movimientoInventarioRepository.findByProductoIdProducto(idProducto);
    }

    @Override
    public List<MovimientoInventario> listarPorProveedor(Integer idProveedor) {
        return movimientoInventarioRepository.findByProveedorIdProveedor(idProveedor);
    }
}
