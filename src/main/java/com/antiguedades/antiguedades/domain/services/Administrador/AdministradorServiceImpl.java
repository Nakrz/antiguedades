package com.antiguedades.antiguedades.domain.services.Administrador;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Administrador;
import com.antiguedades.antiguedades.persistence.repositories.AdministradorRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public List<Administrador> findAll() {
        return (List<Administrador>) administradorRepository.findAll();
    }

    @Override
    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    @Transactional
    public Administrador update(Long id, Administrador administrador) {
        if (!administradorRepository.existsById(id)) {
            throw new EntityNotFoundException("Administrador no encontrado con id " + id);
        }
        administrador.setIdAdministrador(id);
        return administradorRepository.save(administrador);
    }

    @Override
    @Transactional
    public Optional<Administrador> delete(Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) {
            administradorRepository.deleteById(id);
        }
        return administrador;
    }
}
