package com.antiguedades.antiguedades.domain.dto;

import com.antiguedades.antiguedades.persistence.entities.Categorias;

public class CategoriasDTO {

    private Long idCategoria;
    private String nombreCategoria;

    public CategoriasDTO() {
    }

    public CategoriasDTO(Categorias categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.nombreCategoria = categoria.getNombreCategoria();
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
