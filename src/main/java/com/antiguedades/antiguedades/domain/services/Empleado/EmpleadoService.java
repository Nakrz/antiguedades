package com.antiguedades.antiguedades.domain.services.Empleado;

import com.antiguedades.antiguedades.persistence.entities.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    Empleado save(Empleado empleado);
    Empleado update(Long id, Empleado empleado);
    Optional<Empleado> delete(Long id);
}
