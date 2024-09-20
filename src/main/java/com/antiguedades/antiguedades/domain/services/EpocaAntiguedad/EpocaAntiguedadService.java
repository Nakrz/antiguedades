package com.antiguedades.antiguedades.domain.services.EpocaAntiguedad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.EpocaAntiguedad;

public interface EpocaAntiguedadService {

    List<EpocaAntiguedad> findAll();
    Optional<EpocaAntiguedad> findById(Long id);
    EpocaAntiguedad save(EpocaAntiguedad epocaAntiguedad);
    EpocaAntiguedad update(Long id, EpocaAntiguedad epocaAntiguedad);
    Optional<EpocaAntiguedad> delete(Long id);
}