package com.arquitectura.parcial.service;

import com.arquitectura.parcial.models.Empleado;
import com.arquitectura.parcial.models.Proyecto;
import com.arquitectura.parcial.repository.EmpleadoRepository;
import com.arquitectura.parcial.repository.ProyectoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class ProyectoService {


    private final ProyectoRepository proyectoRepository;
    private final EmpleadoRepository empleadoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, EmpleadoRepository empleadoRepository) {
        this.proyectoRepository = proyectoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    // Guardar un proyecto y asociar empleados
    public Proyecto guardarProyecto(Proyecto proyecto) {
        Set<Empleado> empleados = new HashSet<>();

        for (Empleado empleado : proyecto.getEmpleados()) {
            // Validar o crear empleados si no existen
            Empleado empleadoExistente = empleadoRepository.findByCedula(empleado.getCedula());
            if (empleadoExistente == null) {
                empleadoExistente = empleadoRepository.save(empleado);
            }
            empleados.add(empleadoExistente);
        }

        System.out.println("asi se ve " + empleados);

        proyecto.setEmpleados(empleados);
        return proyectoRepository.save(proyecto);
    }

    // Obtener un proyecto
    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

}
