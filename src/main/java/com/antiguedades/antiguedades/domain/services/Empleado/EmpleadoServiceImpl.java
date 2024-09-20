package com.antiguedades.antiguedades.domain.services.Empleado;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Empleado;
import com.antiguedades.antiguedades.persistence.repositories.EmpleadoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Empleado update(Long id, Empleado empleado) {
        if (!empleadoRepository.existsById(id)) {
            throw new EntityNotFoundException("Empleado no encontrado con id " + id);
        }
        empleado.setIdEmpleado(id);
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Optional<Empleado> delete(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (empleado.isPresent()) {
            empleadoRepository.deleteById(id);
        }
        return empleado;
    }
}
