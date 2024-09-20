package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Antiguedades;
import java.math.BigDecimal;


public class AntiguedadesDTO {

    private Long idAntiguedad;
    private String nombreAntiguedad;
    private Long idCategoria;
    private Long idDisponibilidad;
    private Long idRanking;
    private Long idEpoca;
    private String origen;
    private String estadoConservacion;
    private BigDecimal precio;
    private Long idAdministrador;

    public AntiguedadesDTO() {
    }

    public AntiguedadesDTO(Antiguedades antiguedad) {
        this.idAntiguedad = antiguedad.getIdAntiguedad();
        this.nombreAntiguedad = antiguedad.getNombreAntiguedad();
        this.idCategoria = antiguedad.getCategoria() != null ? antiguedad.getCategoria().getIdCategoria() : null;
        this.idDisponibilidad = antiguedad.getDisponibilidad() != null ? antiguedad.getDisponibilidad().getIdDisponibilidad() : null;
        this.idRanking = antiguedad.getRanking() != null ? antiguedad.getRanking().getIdRanking() : null;
        this.idEpoca = antiguedad.getEpoca() != null ? antiguedad.getEpoca().getIdEpoca() : null;
        this.origen = antiguedad.getOrigen();
        this.estadoConservacion = antiguedad.getEstadoConservacion();
        this.precio = antiguedad.getPrecio();
        this.idAdministrador = antiguedad.getAdministrador() != null ? antiguedad.getAdministrador().getIdAdministrador() : null;
    }

    public Long getIdAntiguedad() {
        return idAntiguedad;
    }

    public void setIdAntiguedad(Long idAntiguedad) {
        this.idAntiguedad = idAntiguedad;
    }

    public String getNombreAntiguedad() {
        return nombreAntiguedad;
    }

    public void setNombreAntiguedad(String nombreAntiguedad) {
        this.nombreAntiguedad = nombreAntiguedad;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Long idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public Long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }

    public Long getIdEpoca() {
        return idEpoca;
    }

    public void setIdEpoca(Long idEpoca) {
        this.idEpoca = idEpoca;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
