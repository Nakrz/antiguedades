package com.antiguedades.antiguedades.domain.services.DireccionCliente;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.DireccionCliente;
import com.antiguedades.antiguedades.persistence.repositories.DireccionClienteRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DireccionClienteServiceImpl implements DireccionClienteService {

    @Autowired
    private final DireccionClienteRepository direccionClienteRepository;

    public DireccionClienteServiceImpl(DireccionClienteRepository direccionClienteRepository) {
        this.direccionClienteRepository = direccionClienteRepository;
    }

    @Override
    public List<DireccionCliente> findAll() {
        return (List<DireccionCliente>) direccionClienteRepository.findAll();
    }

    @Override
    public Optional<DireccionCliente> findById(Long id) {
        return direccionClienteRepository.findById(id);
    }

    @Override
    public DireccionCliente save(DireccionCliente direccionCliente) {
        return direccionClienteRepository.save(direccionCliente);
    }

    @Override
    @Transactional
    public DireccionCliente update(Long id, DireccionCliente direccionCliente) {
        if (!direccionClienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Dirección no encontrada con id " + id);
        }
        direccionCliente.setIdDireccion(id);
        return direccionClienteRepository.save(direccionCliente);
    }

    @Override
    @Transactional
    public Optional<DireccionCliente> delete(Long id) {
        Optional<DireccionCliente> direccionCliente = direccionClienteRepository.findById(id);
        if (direccionCliente.isPresent()) {
            direccionClienteRepository.deleteById(id);
        }
        return direccionCliente;
    }
}
