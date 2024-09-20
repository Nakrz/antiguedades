package com.antiguedades.antiguedades.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.antiguedades.antiguedades.persistence.entities.TipoTransaccion;


@Repository
public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion, Long> {
    
}