package com.antiguedades.antiguedades.domain.services.Disponibilidad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Disponibilidad;

public interface DisponibilidadService {

    List<Disponibilidad> findAll();
    Optional<Disponibilidad> findById(Long id);
    Disponibilidad save(Disponibilidad disponibilidad);
    Disponibilidad update(Long id, Disponibilidad disponibilidad);
    Optional<Disponibilidad> delete(Long id);
}



