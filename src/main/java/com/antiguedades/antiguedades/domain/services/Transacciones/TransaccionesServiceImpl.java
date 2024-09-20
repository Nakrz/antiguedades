package com.antiguedades.antiguedades.domain.services.Transacciones;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Transacciones;
import com.antiguedades.antiguedades.persistence.repositories.TransaccionesRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

    @Autowired
    private final TransaccionesRepository transaccionesRepository;

    public TransaccionesServiceImpl(TransaccionesRepository transaccionesRepository) {
        this.transaccionesRepository = transaccionesRepository;
    }

    @Override
    public List<Transacciones> findAll() {
        return (List<Transacciones>) transaccionesRepository.findAll();
    }

    @Override
    public Optional<Transacciones> findById(Long id) {
        return transaccionesRepository.findById(id);
    }

    @Override
    public Transacciones save(Transacciones transaccion) {
        return transaccionesRepository.save(transaccion);
    }

    @Override
    @Transactional
    public Transacciones update(Long id, Transacciones transaccion) {
        if (!transaccionesRepository.existsById(id)) {
            throw new EntityNotFoundException("Transacción no encontrada con id " + id);
        }
        transaccion.setIdTransaccion(id);
        return transaccionesRepository.save(transaccion);
    }

    @Override
    @Transactional
    public Optional<Transacciones> delete(Long id) {
        Optional<Transacciones> transaccion = transaccionesRepository.findById(id);
        if (transaccion.isPresent()) {
            transaccionesRepository.deleteById(id);
        }
        return transaccion;
    }
}
