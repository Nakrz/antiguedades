package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Region;

public class RegionDTO {

    private Long idRegion;
    private String nombreRegion;
    private Long idPais;

    public RegionDTO() {
    }

    public RegionDTO(Region region) {
        this.idRegion = region.getIdRegion();
        this.nombreRegion = region.getNombreRegion();
        this.idPais = region.getPais() != null ? region.getPais().getIdPais() : null;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}
