package com.antiguedades.antiguedades.domain.services.Despachos;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Despachos;
import com.antiguedades.antiguedades.persistence.repositories.DespachosRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DespachosServiceImpl implements DespachosService {

    @Autowired
    private final DespachosRepository despachosRepository;

    public DespachosServiceImpl(DespachosRepository despachosRepository) {
        this.despachosRepository = despachosRepository;
    }

    @Override
    public List<Despachos> findAll() {
        return (List<Despachos>) despachosRepository.findAll();
    }

    @Override
    public Optional<Despachos> findById(Long id) {
        return despachosRepository.findById(id);
    }

    @Override
    public Despachos save(Despachos despacho) {
        return despachosRepository.save(despacho);
    }

    @Override
    @Transactional
    public Despachos update(Long id, Despachos despacho) {
        if (!despachosRepository.existsById(id)) {
            throw new EntityNotFoundException("Despacho no encontrado con id " + id);
        }
        despacho.setIdDespacho(id);
        return despachosRepository.save(despacho);
    }

    @Override
    @Transactional
    public Optional<Despachos> delete(Long id) {
        Optional<Despachos> despacho = despachosRepository.findById(id);
        if (despacho.isPresent()) {
            despachosRepository.deleteById(id);
        }
        return despacho;
    }
}
