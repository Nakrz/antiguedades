package com.antiguedades.antiguedades.domain.services.Ciudad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Ciudad;
import com.antiguedades.antiguedades.persistence.repositories.CiudadRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>) ciudadRepository.findAll();
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    @Transactional
    public Ciudad update(Long id, Ciudad ciudad) {
        if (!ciudadRepository.existsById(id)) {
            throw new EntityNotFoundException("Ciudad no encontrada con id " + id);
        }
        ciudad.setIdCiudad(id); 
        return ciudadRepository.save(ciudad);
    }

    @Override
    @Transactional
    public Optional<Ciudad> delete(Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if (ciudad.isPresent()) {
            ciudadRepository.deleteById(id);
        }
        return ciudad;
    }
}

