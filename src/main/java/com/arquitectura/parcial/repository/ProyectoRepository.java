package com.arquitectura.parcial.repository;

import com.arquitectura.parcial.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
