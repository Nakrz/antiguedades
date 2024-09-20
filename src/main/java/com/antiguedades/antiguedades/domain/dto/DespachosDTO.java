package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Despachos;

public class DespachosDTO {
    
    private Long idDespacho;
    private Long idTransaccion;
    private String fechaDespacho;
    private Long idDireccion;
    private Long idCliente;

    public DespachosDTO() {
    }

    public DespachosDTO(Despachos despacho) {
        this.idDespacho = despacho.getIdDespacho();
        this.idTransaccion = despacho.getTransaccion() != null ? despacho.getTransaccion().getIdTransaccion() : null;
        this.fechaDespacho = despacho.getFechaDespacho() != null ? despacho.getFechaDespacho().toString() : null;
        this.idDireccion = despacho.getDireccion() != null ? despacho.getDireccion().getIdDireccion() : null;
        this.idCliente = despacho.getCliente() != null ? despacho.getCliente().getIdCliente() : null;
    }

    public Long getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(Long idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}