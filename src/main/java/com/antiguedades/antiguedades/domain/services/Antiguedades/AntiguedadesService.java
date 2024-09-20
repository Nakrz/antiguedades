package com.antiguedades.antiguedades.domain.services.Antiguedades;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Antiguedades;

public interface AntiguedadesService {

    List<Antiguedades> findAll();
    Optional<Antiguedades> findById(Long id);
    Antiguedades save(Antiguedades antiguedad);
    Antiguedades update(Long id, Antiguedades antiguedad);
    Optional<Antiguedades> delete(Long id);
}
