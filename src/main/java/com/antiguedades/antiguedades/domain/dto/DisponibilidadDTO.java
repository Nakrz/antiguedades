package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Disponibilidad;

public class DisponibilidadDTO {

    private Long idDisponibilidad;
    private String nombre;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(Disponibilidad disponibilidad) {
        this.idDisponibilidad = disponibilidad.getIdDisponibilidad();
        this.nombre = disponibilidad.getNombre();
    }

    public Long getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Long idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
