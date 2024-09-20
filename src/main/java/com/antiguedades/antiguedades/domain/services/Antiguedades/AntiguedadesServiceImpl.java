package com.antiguedades.antiguedades.domain.services.Antiguedades;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Antiguedades;
import com.antiguedades.antiguedades.persistence.repositories.AntiguedadesRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AntiguedadesServiceImpl implements AntiguedadesService {

    @Autowired
    private final AntiguedadesRepository antiguedadesRepository;

    public AntiguedadesServiceImpl(AntiguedadesRepository antiguedadesRepository) {
        this.antiguedadesRepository = antiguedadesRepository;
    }

    @Override
    public List<Antiguedades> findAll() {
        return (List<Antiguedades>) antiguedadesRepository.findAll();
    }

    @Override
    public Optional<Antiguedades> findById(Long id) {
        return antiguedadesRepository.findById(id);
    }

    @Override
    public Antiguedades save(Antiguedades antiguedad) {
        return antiguedadesRepository.save(antiguedad);
    }

    @Override
    @Transactional
    public Antiguedades update(Long id, Antiguedades antiguedad) {
        if (!antiguedadesRepository.existsById(id)) {
            throw new EntityNotFoundException("Antigüedad no encontrada con id " + id);
        }
        antiguedad.setIdAntiguedad(id);
        return antiguedadesRepository.save(antiguedad);
    }

    @Override
    @Transactional
    public Optional<Antiguedades> delete(Long id) {
        Optional<Antiguedades> antiguedad = antiguedadesRepository.findById(id);
        if (antiguedad.isPresent()) {
            antiguedadesRepository.deleteById(id);
        }
        return antiguedad;
    }
}
