package com.arquitectura.parcial.DTO;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoInputDTO {

    private  String nombre;
    private String apellido;
    private String cedula;
    private String rol;

}
