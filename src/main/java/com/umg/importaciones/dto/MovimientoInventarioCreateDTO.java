package com.umg.importaciones.dto;

import com.umg.importaciones.enums.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventarioCreateDTO {

    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private String descripcion;
    private Integer productoId;
    private Integer proveedorId;
}
