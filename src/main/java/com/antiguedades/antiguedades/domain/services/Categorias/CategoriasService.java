package com.antiguedades.antiguedades.domain.services.Categorias;

import java.util.List;
import java.util.Optional;
import com.antiguedades.antiguedades.persistence.entities.Categorias;

public interface CategoriasService {

    List<Categorias> findAll();
    Optional<Categorias> findById(Long id);
    Categorias save(Categorias categoria);
    Categorias update(Long id, Categorias categoria);
    Optional<Categorias> delete(Long id);
}
