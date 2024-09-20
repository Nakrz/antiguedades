package com.antiguedades.antiguedades.domain.services.Administrador;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Administrador;

public interface AdministradorService {

    List<Administrador> findAll();
    Optional<Administrador> findById(Long id);
    Administrador save(Administrador administrador);
    Administrador update(Long id, Administrador administrador);
    Optional<Administrador> delete(Long id);
}