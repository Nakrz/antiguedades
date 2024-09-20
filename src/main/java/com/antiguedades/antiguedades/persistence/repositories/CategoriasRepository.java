package com.antiguedades.antiguedades.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.antiguedades.antiguedades.persistence.entities.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    
}

