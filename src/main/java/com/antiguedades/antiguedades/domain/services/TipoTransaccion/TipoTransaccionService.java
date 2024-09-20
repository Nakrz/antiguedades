package com.antiguedades.antiguedades.domain.services.TipoTransaccion;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.TipoTransaccion;

public interface TipoTransaccionService {

    List<TipoTransaccion> findAll();
    Optional<TipoTransaccion> findById(Long id);
    TipoTransaccion save(TipoTransaccion tipoTransaccion);
    TipoTransaccion update(Long id, TipoTransaccion tipoTransaccion);
    Optional<TipoTransaccion> delete(Long id);
}
