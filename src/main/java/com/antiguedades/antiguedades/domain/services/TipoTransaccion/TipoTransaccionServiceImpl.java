package com.antiguedades.antiguedades.domain.services.TipoTransaccion;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.TipoTransaccion;
import com.antiguedades.antiguedades.persistence.repositories.TipoTransaccionRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoTransaccionServiceImpl implements TipoTransaccionService {

    @Autowired
    private final TipoTransaccionRepository tipoTransaccionRepository;

    public TipoTransaccionServiceImpl(TipoTransaccionRepository tipoTransaccionRepository) {
        this.tipoTransaccionRepository = tipoTransaccionRepository;
    }

    @Override
    public List<TipoTransaccion> findAll() {
        return (List<TipoTransaccion>) tipoTransaccionRepository.findAll();
    }

    @Override
    public Optional<TipoTransaccion> findById(Long id) {
        return tipoTransaccionRepository.findById(id);
    }

    @Override
    public TipoTransaccion save(TipoTransaccion tipoTransaccion) {
        return tipoTransaccionRepository.save(tipoTransaccion);
    }

    @Override
    @Transactional
    public TipoTransaccion update(Long id, TipoTransaccion tipoTransaccion) {
        if (!tipoTransaccionRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de transacción no encontrado con id " + id);
        }
        tipoTransaccion.setIdTipoTransaccion(id);
        return tipoTransaccionRepository.save(tipoTransaccion);
    }

    @Override
    @Transactional
    public Optional<TipoTransaccion> delete(Long id) {
        Optional<TipoTransaccion> tipoTransaccion = tipoTransaccionRepository.findById(id);
        if (tipoTransaccion.isPresent()) {
            tipoTransaccionRepository.deleteById(id);
        }
        return tipoTransaccion;
    }
}
