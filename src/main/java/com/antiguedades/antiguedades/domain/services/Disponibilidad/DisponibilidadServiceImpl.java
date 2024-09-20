package com.antiguedades.antiguedades.domain.services.Disponibilidad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Disponibilidad;
import com.antiguedades.antiguedades.persistence.repositories.DisponibilidadRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    @Autowired
    private final DisponibilidadRepository disponibilidadRepository;

    public DisponibilidadServiceImpl(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }

    @Override
    public List<Disponibilidad> findAll() {
        return (List<Disponibilidad>) disponibilidadRepository.findAll();
    }

    @Override
    public Optional<Disponibilidad> findById(Long id) {
        return disponibilidadRepository.findById(id);
    }

    @Override
    public Disponibilidad save(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    @Transactional
    public Disponibilidad update(Long id, Disponibilidad disponibilidad) {
        if (!disponibilidadRepository.existsById(id)) {
            throw new EntityNotFoundException("Disponibilidad no encontrada con id " + id);
        }
        disponibilidad.setIdDisponibilidad(id);
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    @Transactional
    public Optional<Disponibilidad> delete(Long id) {
        Optional<Disponibilidad> disponibilidad = disponibilidadRepository.findById(id);
        if (disponibilidad.isPresent()) {
            disponibilidadRepository.deleteById(id);
        }
        return disponibilidad;
    }
}
