package com.bazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VentaDetalleDTO {

    private Long codigoProducto;
    private String nombreProducto;
    private Integer cantidad;
}
