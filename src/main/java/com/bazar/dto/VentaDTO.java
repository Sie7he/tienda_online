package com.bazar.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VentaDTO {

    private Long idVenta;
    @NotNull
    private Long idCliente;
    @NotNull
    private LocalDate fecha;
    @NotEmpty
    private List<VentaDetalleDTO> detalleDTOS;
    @NotNull
    private int total;
}
