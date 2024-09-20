package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Transacciones;

public class TransaccionesDTO {

    private Long idTransaccion;
    private Long idAntiguedad;
    private Long idCliente;
    private Long idAdministrador;
    private String fechaTransaccion;
    private Long idTipoTransaccion;
    private Integer cantidad;

    public TransaccionesDTO() {
    }

    public TransaccionesDTO(Transacciones transaccion) {
        this.idTransaccion = transaccion.getIdTransaccion();
        this.idAntiguedad = transaccion.getAntiguedad() != null ? transaccion.getAntiguedad().getIdAntiguedad() : null;
        this.idCliente = transaccion.getCliente() != null ? transaccion.getCliente().getIdCliente() : null;
        this.idAdministrador = transaccion.getAdministrador() != null ? transaccion.getAdministrador().getIdAdministrador() : null;
        this.fechaTransaccion = transaccion.getFechaTransaccion() != null ? transaccion.getFechaTransaccion().toString() : null;
        this.idTipoTransaccion = transaccion.getTipoTransaccion() != null ? transaccion.getTipoTransaccion().getIdTipoTransaccion() : null;
        this.cantidad = transaccion.getCantidad();
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getIdAntiguedad() {
        return idAntiguedad;
    }

    public void setIdAntiguedad(Long idAntiguedad) {
        this.idAntiguedad = idAntiguedad;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Long getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}