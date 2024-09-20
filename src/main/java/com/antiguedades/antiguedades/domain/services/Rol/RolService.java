package com.antiguedades.antiguedades.domain.services.Rol;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Rol;

public interface RolService {

    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    Rol update(Long id, Rol rol);
    Optional<Rol> delete(Long id);
}
