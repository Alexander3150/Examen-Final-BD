package com.umg.importaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    private Integer idProveedor;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
}
