package com.antiguedades.antiguedades.domain.services.Despachos;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Despachos;

public interface DespachosService {

    List<Despachos> findAll();
    Optional<Despachos> findById(Long id);
    Despachos save(Despachos despacho);
    Despachos update(Long id, Despachos despacho);
    Optional<Despachos> delete(Long id);
}