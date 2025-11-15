package com.umg.importaciones.mapper;

import com.umg.importaciones.dto.MovimientoInventarioCreateDTO;
import com.umg.importaciones.dto.MovimientoInventarioDTO;
import com.umg.importaciones.dto.ProductoDTO;
import com.umg.importaciones.dto.ProveedorDTO;
import com.umg.importaciones.entity.MovimientoInventario;
import com.umg.importaciones.entity.Producto;
import com.umg.importaciones.entity.Proveedor;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class ImportacionesMapper {

    public ProveedorDTO toProveedorDTO(Proveedor entity) {
        if (entity == null) {
            return null;
        }
        return new ProveedorDTO(
                entity.getIdProveedor(),
                entity.getNombre(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getDireccion());
    }

    public Proveedor toProveedorEntity(ProveedorDTO dto) {
        if (dto == null) {
            return null;
        }
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(dto.getIdProveedor());
        proveedor.setNombre(dto.getNombre());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setEmail(dto.getEmail());
        proveedor.setDireccion(dto.getDireccion());
        return proveedor;
    }

    public ProductoDTO toProductoDTO(Producto entity) {
        if (entity == null) {
            return null;
        }
        return new ProductoDTO(
                entity.getIdProducto(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getUnidadMedida(),
                entity.getStockActual(),
                entity.getPrecioCompra(),
                entity.getPrecioVenta(),
                entity.getEstado());
    }

    public Producto toProductoEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setUnidadMedida(dto.getUnidadMedida());
        producto.setStockActual(dto.getStockActual());
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setEstado(dto.getEstado());
        return producto;
    }

    public MovimientoInventarioDTO toMovimientoDTO(MovimientoInventario entity) {
        if (entity == null) {
            return null;
        }
        Producto producto = entity.getProducto();
        Proveedor proveedor = entity.getProveedor();

        Integer productoId = producto != null ? producto.getIdProducto() : null;
        String productoNombre = producto != null ? producto.getNombre() : null;

        Integer proveedorId = proveedor != null ? proveedor.getIdProveedor() : null;
        String proveedorNombre = proveedor != null ? proveedor.getNombre() : null;

        return new MovimientoInventarioDTO(
                entity.getIdMovimiento(),
                entity.getFechaMovimiento(),
                entity.getTipoMovimiento(),
                entity.getCantidad(),
                entity.getDescripcion(),
                productoId,
                productoNombre,
                proveedorId,
                proveedorNombre);
    }

    public MovimientoInventario toMovimientoEntityFromCreateDTO(
            MovimientoInventarioCreateDTO dto, Producto producto, Proveedor proveedor) {
        if (dto == null) {
            return null;
        }

        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setFechaMovimiento(LocalDateTime.now());
        movimiento.setTipoMovimiento(dto.getTipoMovimiento());
        movimiento.setCantidad(dto.getCantidad());
        movimiento.setDescripcion(dto.getDescripcion());
        movimiento.setProducto(producto);
        movimiento.setProveedor(proveedor);
        return movimiento;
    }
}
