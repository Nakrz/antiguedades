package com.antiguedades.antiguedades.domain.services.DireccionCliente;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.DireccionCliente;

public interface DireccionClienteService {

    List<DireccionCliente> findAll();
    Optional<DireccionCliente> findById(Long id);
    DireccionCliente save(DireccionCliente direccionCliente);
    DireccionCliente update(Long id, DireccionCliente direccionCliente);
    Optional<DireccionCliente> delete(Long id);
}