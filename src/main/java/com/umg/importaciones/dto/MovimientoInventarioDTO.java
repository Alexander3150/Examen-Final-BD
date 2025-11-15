package com.umg.importaciones.dto;

import com.umg.importaciones.enums.TipoMovimiento;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventarioDTO {

    private Integer idMovimiento;
    private LocalDateTime fechaMovimiento;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private String descripcion;
    private Integer productoId;
    private String productoNombre;
    private Integer proveedorId;
    private String proveedorNombre;
}
