package com.antiguedades.antiguedades.domain.services.RankingAntiguedad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.RankingAntiguedad;

public interface RankingAntiguedadService {

    List<RankingAntiguedad> findAll();
    Optional<RankingAntiguedad> findById(Long id);
    RankingAntiguedad save(RankingAntiguedad rankingAntiguedad);
    RankingAntiguedad update(Long id, RankingAntiguedad rankingAntiguedad);
    Optional<RankingAntiguedad> delete(Long id);
}