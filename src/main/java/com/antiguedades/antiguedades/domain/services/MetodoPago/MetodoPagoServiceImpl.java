package com.antiguedades.antiguedades.domain.services.MetodoPago;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.MetodoPago;
import com.antiguedades.antiguedades.persistence.repositories.MetodoPagoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoServiceImpl(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<MetodoPago> findAll() {
        return (List<MetodoPago>) metodoPagoRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> findById(Long id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    @Transactional
    public MetodoPago update(Long id, MetodoPago metodoPago) {
        if (!metodoPagoRepository.existsById(id)) {
            throw new EntityNotFoundException("Método de pago no encontrado con id " + id);
        }
        metodoPago.setIdMetodoPago(id);
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    @Transactional
    public Optional<MetodoPago> delete(Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(id);
        if (metodoPago.isPresent()) {
            metodoPagoRepository.deleteById(id);
        }
        return metodoPago;
    }
}
