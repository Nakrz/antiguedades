package com.antiguedades.antiguedades.domain.services.EpocaAntiguedad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.EpocaAntiguedad;
import com.antiguedades.antiguedades.persistence.repositories.EpocaAntiguedadRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EpocaAntiguedadServiceImpl implements EpocaAntiguedadService {

    @Autowired
    private final EpocaAntiguedadRepository epocaAntiguedadRepository;

    public EpocaAntiguedadServiceImpl(EpocaAntiguedadRepository epocaAntiguedadRepository) {
        this.epocaAntiguedadRepository = epocaAntiguedadRepository;
    }

    @Override
    public List<EpocaAntiguedad> findAll() {
        return (List<EpocaAntiguedad>) epocaAntiguedadRepository.findAll();
    }

    @Override
    public Optional<EpocaAntiguedad> findById(Long id) {
        return epocaAntiguedadRepository.findById(id);
    }

    @Override
    public EpocaAntiguedad save(EpocaAntiguedad epocaAntiguedad) {
        return epocaAntiguedadRepository.save(epocaAntiguedad);
    }

    @Override
    @Transactional
    public EpocaAntiguedad update(Long id, EpocaAntiguedad epocaAntiguedad) {
        if (!epocaAntiguedadRepository.existsById(id)) {
            throw new EntityNotFoundException("Época no encontrada con id " + id);
        }
        epocaAntiguedad.setIdEpoca(id);
        return epocaAntiguedadRepository.save(epocaAntiguedad);
    }

    @Override
    @Transactional
    public Optional<EpocaAntiguedad> delete(Long id) {
        Optional<EpocaAntiguedad> epocaAntiguedad = epocaAntiguedadRepository.findById(id);
        if (epocaAntiguedad.isPresent()) {
            epocaAntiguedadRepository.deleteById(id);
        }
        return epocaAntiguedad;
    }
}
