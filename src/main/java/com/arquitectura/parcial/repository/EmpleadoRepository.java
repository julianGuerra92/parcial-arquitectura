package com.arquitectura.parcial.repository;

import com.arquitectura.parcial.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByCedula(String cedula);

}
