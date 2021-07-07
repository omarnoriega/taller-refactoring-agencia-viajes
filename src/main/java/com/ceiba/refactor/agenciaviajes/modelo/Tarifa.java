package com.ceiba.refactor.agenciaviajes.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double porcentaje_incremento;
    private String tipo_clase;


    public Tarifa(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPorcentajeIncremento() {
        return porcentaje_incremento;
    }

    public void setPorcentajeIncremento(Double porcentajeIncremento) {
        this.porcentaje_incremento = porcentajeIncremento;
    }

    public String getTipoClase() {
        return tipo_clase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipo_clase = tipoClase;
    }
}
