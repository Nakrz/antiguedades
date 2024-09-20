package com.antiguedades.antiguedades.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "despachos")
public class Despachos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despacho")
    private Long idDespacho;

    @ManyToOne
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")
    private Transacciones transaccion;

    @Column(name = "fecha_despacho")
    private java.sql.Date fechaDespacho;

    @ManyToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    private DireccionCliente direccion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Long getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(Long idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Transacciones getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transacciones transaccion) {
        this.transaccion = transaccion;
    }

    public java.sql.Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(java.sql.Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public DireccionCliente getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionCliente direccion) {
        this.direccion = direccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}