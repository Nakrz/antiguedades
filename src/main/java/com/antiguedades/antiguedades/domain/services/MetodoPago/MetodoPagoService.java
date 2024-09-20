package com.antiguedades.antiguedades.domain.services.MetodoPago;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.MetodoPago;

public interface MetodoPagoService {

    List<MetodoPago> findAll();
    Optional<MetodoPago> findById(Long id);
    MetodoPago save(MetodoPago metodoPago);
    MetodoPago update(Long id, MetodoPago metodoPago);
    Optional<MetodoPago> delete(Long id);
}