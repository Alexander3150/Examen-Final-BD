package com.umg.importaciones.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String unidadMedida;
    private Integer stockActual;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private String estado;
}
