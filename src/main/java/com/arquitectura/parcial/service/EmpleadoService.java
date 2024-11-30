package com.arquitectura.parcial.service;

import com.arquitectura.parcial.DTO.EmpleadoInputDTO;
import com.arquitectura.parcial.models.Empleado;
import com.arquitectura.parcial.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // Buscar un empleado por su documento
    public Empleado obtenerEmpleadoPorCedula(String cedula) {
        return empleadoRepository.findByCedula(cedula);
    }

    // Registrar un nuevo empleado
    public Boolean guardarEmpleado(EmpleadoInputDTO empleado) {
        System.out.println(empleado);

        Empleado newEmpleado = new Empleado();

        newEmpleado.setCedula(empleado.getCedula());
        newEmpleado.setNombre(empleado.getNombre());
        newEmpleado.setApellido(empleado.getApellido());
        newEmpleado.setRol(empleado.getRol());


        var result = empleadoRepository.save(newEmpleado);

        if (result != null) {
            return true;
        }

        return false;
    }

}
