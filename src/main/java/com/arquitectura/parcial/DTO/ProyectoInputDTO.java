package com.arquitectura.parcial.DTO;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoInputDTO {

    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;

    private List<EmpleadoInputDTO> empleados;

}
