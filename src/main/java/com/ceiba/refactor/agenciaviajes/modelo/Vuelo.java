package com.ceiba.refactor.agenciaviajes.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vueloId;
    private String vueloOrigen;
    private String vueloDestino;
    private String vueloClase;
    private Double vueloPrecio;
    private Date vueloFecha;


    public Vuelo(String vueloOrigen, String vueloDestino, String vueloClase, Double vueloPrecio, Date vueloFecha) {
        this.vueloOrigen = vueloOrigen;
        this.vueloDestino = vueloDestino;
        this.vueloClase = vueloClase;
        this.vueloPrecio = vueloPrecio;
        this.vueloFecha = vueloFecha;
    }

    public Vuelo() {

    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public String getVueloOrigen() {
        return vueloOrigen;
    }

    public void setVueloOrigen(String vueloOrigen) {
        this.vueloOrigen = vueloOrigen;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }

    public void setVueloDestino(String vueloDestino) {
        this.vueloDestino = vueloDestino;
    }

    public String getVueloClase() {
        return vueloClase;
    }

    public void setVueloClase(String vueloClase) {
        this.vueloClase = vueloClase;
    }

    public Double getVueloPrecio() {
        return vueloPrecio;
    }

    public void setVueloPrecio(Double vueloPrecio) {
        this.vueloPrecio = vueloPrecio;
    }

    public Date getVueloFecha() {
        return vueloFecha;
    }

    public void setVueloFecha(Date vueloFecha) {
        this.vueloFecha = vueloFecha;
    }
}
