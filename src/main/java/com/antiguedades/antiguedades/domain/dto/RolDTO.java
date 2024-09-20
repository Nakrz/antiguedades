package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Rol;

public class RolDTO {

    private Long idRol;
    private String nombreRol;

    public RolDTO() {
    }

    public RolDTO(Rol rol) {
        this.idRol = rol.getIdRol();
        this.nombreRol = rol.getNombreRol();
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}

