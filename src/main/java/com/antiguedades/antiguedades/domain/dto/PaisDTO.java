package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Pais;

public class PaisDTO {

    private Long idPais;
    private String nombrePais;

    public PaisDTO() {
    }

    public PaisDTO(Pais pais) {
        this.idPais = pais.getIdPais();
        this.nombrePais = pais.getNombrePais();
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
