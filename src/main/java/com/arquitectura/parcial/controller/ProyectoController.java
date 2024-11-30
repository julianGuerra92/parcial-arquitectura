package com.arquitectura.parcial.controller;

import com.arquitectura.parcial.models.Proyecto;
import com.arquitectura.parcial.service.ProyectoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ProyectoController {


    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @MutationMapping
    public void  registrarProyecto(@Argument Proyecto input) {
        proyectoService.guardarProyecto(input);
    }

    @QueryMapping
    public ResponseEntity<Proyecto> proyectosPorEmpleado(@Argument Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        }
        return ResponseEntity.notFound().build();
    }


}
