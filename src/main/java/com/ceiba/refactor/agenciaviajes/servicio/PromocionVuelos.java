package com.ceiba.refactor.agenciaviajes.servicio;

import com.ceiba.refactor.agenciaviajes.modelo.Ruta;
import com.ceiba.refactor.agenciaviajes.modelo.Tarifa;
import com.ceiba.refactor.agenciaviajes.modelo.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PromocionVuelos {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Vuelo> genererVuelos() {
        List<Ruta> rutas = entityManager.createQuery("SELECT r FROM Ruta r", Ruta.class).getResultList();
        List<Tarifa> tarifas = entityManager.createQuery("SELECT t FROM Tarifa t", Tarifa.class).getResultList();
        List<Vuelo> vuelos = new ArrayList<>();

        for (Ruta ruta : rutas) {
            for (Tarifa tarifa : tarifas) {
            //Si es una ciudad del eje cafetero, aplique un descuento según ciudad
            if (ruta.getDestino_codigo().equals("AXM")) {

                    Vuelo vuelo = new Vuelo();
                    vuelo.setVueloDestino(ruta.getDestino_codigo());
                    vuelo.setVueloOrigen(ruta.getOrigen_codigo());
                    vuelo.setVueloPrecio(ruta.getPrecio_base()
                            + (ruta.getPrecio_base() * tarifa.getPorcentajeIncremento())
                            - (ruta.getPrecio_base() - 50000)
                    );
                    vuelo.setVueloClase(tarifa.getTipoClase());
                    vuelo.setVueloFecha(new Date());
                    vuelos.add(vuelo);
                }
            if (ruta.getDestino_codigo().equals("PEI")) {

                    Vuelo vuelo = new Vuelo();
                    vuelo.setVueloDestino(ruta.getDestino_codigo());
                    vuelo.setVueloOrigen(ruta.getOrigen_codigo());
                    vuelo.setVueloPrecio(ruta.getPrecio_base()
                            + (ruta.getPrecio_base() * tarifa.getPorcentajeIncremento())
                            - (ruta.getPrecio_base() - 30000)
                    );
                    vuelo.setVueloClase(tarifa.getTipoClase());
                    vuelo.setVueloFecha(new Date());
                    vuelos.add(vuelo);

            }
            if (ruta.getDestino_codigo().equals("MNZ")) {

                    Vuelo vuelo = new Vuelo();
                    vuelo.setVueloDestino(ruta.getDestino_codigo());
                    vuelo.setVueloOrigen(ruta.getOrigen_codigo());
                    vuelo.setVueloPrecio(ruta.getPrecio_base()
                            + (ruta.getPrecio_base() * tarifa.getPorcentajeIncremento())
                            - (ruta.getPrecio_base() - 75000)
                    );
                    vuelo.setVueloClase(tarifa.getTipoClase());
                    vuelo.setVueloFecha(new Date());
                    vuelos.add(vuelo);

             }
            }
        }
        vuelos.forEach(vuelo -> entityManager.persist(vuelo));
        return vuelos;
    }
}