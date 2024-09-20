package com.antiguedades.antiguedades.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "antiguedades")
public class Antiguedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_antiguedad")
    private Long idAntiguedad;

    @Column(name = "nombre_antiguedad")
    private String nombreAntiguedad;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categorias categorias;

    @ManyToOne
    @JoinColumn(name = "id_disponibilidad", referencedColumnName = "id_disponibilidad")
    private Disponibilidad disponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_ranking", referencedColumnName = "id_ranking")
    private RankingAntiguedad ranking;

    @ManyToOne
    @JoinColumn(name = "id_epoca", referencedColumnName = "id_epoca")
    private EpocaAntiguedad epoca;

    @Column(name = "origen")
    private String origen;

    @Column(name = "estado_conservacion")
    private String estadoConservacion;

    @Column(name = "precio")
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_administrador")
    private Administrador administrador;

    
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

    public Categorias getCategoria() {
        return categorias;
    }

    public void setCategoria(Categorias categorias) {
        this.categorias = categorias;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public RankingAntiguedad getRanking() {
        return ranking;
    }

    public void setRanking(RankingAntiguedad ranking) {
        this.ranking = ranking;
    }

    public EpocaAntiguedad getEpoca() {
        return epoca;
    }

    public void setEpoca(EpocaAntiguedad epoca) {
        this.epoca = epoca;
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}