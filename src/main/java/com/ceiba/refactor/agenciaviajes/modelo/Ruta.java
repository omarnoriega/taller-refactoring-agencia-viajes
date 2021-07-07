package com.ceiba.refactor.agenciaviajes.modelo;
import javax.persistence.*;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutaId;
    private String destino_codigo;
    private String destino_nombre;
    private String origen_codigo;
    private String origen_nombre;
    private Double precio_base;
    public Ruta() {
    }

    public Long getRutaId() {
        return rutaId;
    }

    public void setRutaId(Long rutaId) {
        this.rutaId = rutaId;
    }

    public String getDestino_codigo() {
        return destino_codigo;
    }

    public void setDestino_codigo(String destino_codigo) {
        this.destino_codigo = destino_codigo;
    }

    public String getDestino_nombre() {
        return destino_nombre;
    }

    public void setDestino_nombre(String destino_nombre) {
        this.destino_nombre = destino_nombre;
    }

    public String getOrigen_codigo() {
        return origen_codigo;
    }

    public void setOrigen_codigo(String origen_codigo) {
        this.origen_codigo = origen_codigo;
    }

    public String getOrigen_nombre() {
        return origen_nombre;
    }

    public void setOrigen_nombre(String origen_nombre) {
        this.origen_nombre = origen_nombre;
    }

    public Double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(Double precio_base) {
        this.precio_base = precio_base;
    }
}
