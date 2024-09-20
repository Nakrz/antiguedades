package com.antiguedades.antiguedades.domain.services.Ciudad;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Ciudad;

public interface CiudadService {

    List<Ciudad> findAll();
    Optional<Ciudad> findById(Long id);
    Ciudad save(Ciudad ciudad);
    Ciudad update(Long id, Ciudad ciudad);
    Optional<Ciudad> delete(Long id);
    
}
