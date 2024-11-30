package com.arquitectura.parcial.controller;

import com.arquitectura.parcial.DTO.EmpleadoInputDTO;
import com.arquitectura.parcial.models.Empleado;
import com.arquitectura.parcial.service.EmpleadoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @MutationMapping
    public void registrarEmpleado(@Argument EmpleadoInputDTO input) {

        System.out.println("asi llega "+input);

        empleadoService.guardarEmpleado(input);
    }

    @QueryMapping
    public ResponseEntity<Empleado> obtenerEmpleado(@Argument String id) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorCedula(id);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        }
        return ResponseEntity.notFound().build();
    }

}
