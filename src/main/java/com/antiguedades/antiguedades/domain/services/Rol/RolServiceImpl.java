package com.antiguedades.antiguedades.domain.services.Rol;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Rol;
import com.antiguedades.antiguedades.persistence.repositories.RolRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    @Transactional
    public Rol update(Long id, Rol rol) {
        if (!rolRepository.existsById(id)) {
            throw new EntityNotFoundException("Rol no encontrado con id " + id);
        }
        rol.setIdRol(id);
        return rolRepository.save(rol);
    }

    @Override
    @Transactional
    public Optional<Rol> delete(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            rolRepository.deleteById(id);
        }
        return rol;
    }
}
