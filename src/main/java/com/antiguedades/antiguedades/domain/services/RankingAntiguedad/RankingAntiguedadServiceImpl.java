package com.antiguedades.antiguedades.domain.services.RankingAntiguedad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.RankingAntiguedad;
import com.antiguedades.antiguedades.persistence.repositories.RankingAntiguedadRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RankingAntiguedadServiceImpl implements RankingAntiguedadService {

    @Autowired
    private final RankingAntiguedadRepository rankingAntiguedadRepository;

    public RankingAntiguedadServiceImpl(RankingAntiguedadRepository rankingAntiguedadRepository) {
        this.rankingAntiguedadRepository = rankingAntiguedadRepository;
    }

    @Override
    public List<RankingAntiguedad> findAll() {
        return (List<RankingAntiguedad>) rankingAntiguedadRepository.findAll();
    }

    @Override
    public Optional<RankingAntiguedad> findById(Long id) {
        return rankingAntiguedadRepository.findById(id);
    }

    @Override
    public RankingAntiguedad save(RankingAntiguedad rankingAntiguedad) {
        return rankingAntiguedadRepository.save(rankingAntiguedad);
    }

    @Override
    @Transactional
    public RankingAntiguedad update(Long id, RankingAntiguedad rankingAntiguedad) {
        if (!rankingAntiguedadRepository.existsById(id)) {
            throw new EntityNotFoundException("Ranking no encontrado con id " + id);
        }
        rankingAntiguedad.setIdRanking(id);
        return rankingAntiguedadRepository.save(rankingAntiguedad);
    }

    @Override
    @Transactional
    public Optional<RankingAntiguedad> delete(Long id) {
        Optional<RankingAntiguedad> rankingAntiguedad = rankingAntiguedadRepository.findById(id);
        if (rankingAntiguedad.isPresent()) {
            rankingAntiguedadRepository.deleteById(id);
        }
        return rankingAntiguedad;
    }
}
