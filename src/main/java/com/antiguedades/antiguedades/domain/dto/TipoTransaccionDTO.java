package com.antiguedades.antiguedades.domain.dto;


import com.antiguedades.antiguedades.persistence.entities.TipoTransaccion;

public class TipoTransaccionDTO {

    private Long idTipoTransaccion;
    private String descripcion;

    public TipoTransaccionDTO() {
    }

    public TipoTransaccionDTO(TipoTransaccion tipoTransaccion) {
        this.idTipoTransaccion = tipoTransaccion.getIdTipoTransaccion();
        this.descripcion = tipoTransaccion.getDescripcion();
    }

    public Long getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
