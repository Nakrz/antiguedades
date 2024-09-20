package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.MetodoPago;

public class MetodoPagoDTO {

    private Long idMetodoPago;
    private String nombreMetodoPago;

    public MetodoPagoDTO() {
    }

    public MetodoPagoDTO(MetodoPago metodoPago) {
        this.idMetodoPago = metodoPago.getIdMetodoPago();
        this.nombreMetodoPago = metodoPago.getNombreMetodoPago();
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }
}
