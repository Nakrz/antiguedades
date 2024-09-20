package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.DireccionCliente;

public class DireccionClienteDTO {

    private Long idDireccion;
    private Long idCliente;
    private String direccion1;
    private String direccion2;
    private Long idCiudad;

    public DireccionClienteDTO() {
    }

    public DireccionClienteDTO(DireccionCliente direccionCliente) {
        this.idDireccion = direccionCliente.getIdDireccion();
        this.idCliente = direccionCliente.getCliente() != null ? direccionCliente.getCliente().getIdCliente() : null;
        this.direccion1 = direccionCliente.getDireccion1();
        this.direccion2 = direccionCliente.getDireccion2();
        this.idCiudad = direccionCliente.getCiudad() != null ? direccionCliente.getCiudad().getIdCiudad() : null;
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

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }
}
