package com.antiguedades.antiguedades.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "epoca_antiguedad")
public class EpocaAntiguedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_epoca")
    private Long idEpoca;

    @Column(name = "nombre_epoca")
    private String nombreEpoca;

    public Long getIdEpoca() {
        return idEpoca;
    }

    public void setIdEpoca(Long idEpoca) {
        this.idEpoca = idEpoca;
    }

    public String getNombreEpoca() {
        return nombreEpoca;
    }

    public void setNombreEpoca(String nombreEpoca) {
        this.nombreEpoca = nombreEpoca;
    }
}
