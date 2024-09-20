package com.antiguedades.antiguedades.domain.services.Transacciones;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Transacciones;

public interface TransaccionesService {

    List<Transacciones> findAll();
    Optional<Transacciones> findById(Long id);
    Transacciones save(Transacciones transaccion);
    Transacciones update(Long id, Transacciones transaccion);
    Optional<Transacciones> delete(Long id);
}
