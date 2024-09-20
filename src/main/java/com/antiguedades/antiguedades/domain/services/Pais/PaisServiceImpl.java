package com.antiguedades.antiguedades.domain.services.Pais;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Pais;
import com.antiguedades.antiguedades.persistence.repositories.PaisRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<Pais> findAll() {
        return (List<Pais>) paisRepository.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    @Transactional
    public Pais update(Long id, Pais pais) {
        if (!paisRepository.existsById(id)) {
            throw new EntityNotFoundException("País no encontrado con id " + id);
        }
        pais.setIdPais(id);
        return paisRepository.save(pais);
    }

    @Override
    @Transactional
    public Optional<Pais> delete(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            paisRepository.deleteById(id);
        }
        return pais;
    }
}
