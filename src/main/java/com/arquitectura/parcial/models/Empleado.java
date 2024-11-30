package com.arquitectura.parcial.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String nombre;
    @Column()
    private String apellido;
    @Column(unique = true)
    private String cedula;
    @Column()
    private String rol;

    @ManyToMany(mappedBy = "empleados")
    private Set<Proyecto> proyectos = new HashSet<>();
}
