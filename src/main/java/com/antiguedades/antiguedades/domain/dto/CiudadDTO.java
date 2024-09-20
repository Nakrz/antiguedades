package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Ciudad; 

public class CiudadDTO {

    private Long idCiudad;
    private String nombreCiudad;
    private Long idRegion;

    
    public CiudadDTO() {
    }


    public CiudadDTO(Ciudad ciudad) {
        this.idCiudad = ciudad.getIdCiudad();
        this.nombreCiudad = ciudad.getNombreCiudad();
        this.idRegion = ciudad.getRegion() != null ? ciudad.getRegion().getIdRegion() : null;
    }

    
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }
}

