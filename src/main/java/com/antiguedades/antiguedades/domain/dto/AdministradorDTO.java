package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Administrador;

public class AdministradorDTO {

    private Long idAdministrador;
    private String nombreAdministrador;
    private String apellidoAdministrador;
    private String correo;

    public AdministradorDTO() {
    }

    public AdministradorDTO(Administrador administrador) {
        this.idAdministrador = administrador.getIdAdministrador();
        this.nombreAdministrador = administrador.getNombreAdministrador();
        this.apellidoAdministrador = administrador.getApellidoAdministrador();
        this.correo = administrador.getCorreo();
    }

    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
