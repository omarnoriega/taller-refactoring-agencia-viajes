package com.ceiba.refactor.agenciaviajes.modelo;

import java.util.Date;

public class VueloRespuesta {


    private String codCiudadOrigen;
    private String ciudadOrigen;
    private String codCiudadDestino;
    private String ciudadDestino;
    private String clase;
    private Double precio;
    private Date fecha;

    public String getCodCiudadOrigen() {
        return codCiudadOrigen;
    }

    public void setCodCiudadOrigen(String codCiudadOrigen) {
        this.codCiudadOrigen = codCiudadOrigen;
    }

    public String getCodCiudadDestino() {
        return codCiudadDestino;
    }

    public void setCodCiudadDestino(String codCiudadDestino) {
        this.codCiudadDestino = codCiudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
