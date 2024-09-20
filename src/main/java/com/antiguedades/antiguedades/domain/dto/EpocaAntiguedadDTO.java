package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.EpocaAntiguedad;

public class EpocaAntiguedadDTO {

    private Long idEpoca;
    private String nombreEpoca;

    public EpocaAntiguedadDTO() {
    }

    public EpocaAntiguedadDTO(EpocaAntiguedad epoca) {
        this.idEpoca = epoca.getIdEpoca();
        this.nombreEpoca = epoca.getNombreEpoca();
    }

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
