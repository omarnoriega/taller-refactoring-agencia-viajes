package com.ceiba.refactor.agenciaviajes.servicio;

import com.ceiba.refactor.agenciaviajes.modelo.Vuelo;
import com.ceiba.refactor.agenciaviajes.modelo.VueloRespuesta;
import com.ceiba.refactor.agenciaviajes.repositorio.VueloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("vuelos")
public class PromocionVuelosController {


    VueloRepositorio vueloRepositorio;
    VueloRespuesta vueloRespuesta;

    @Autowired
    PromocionVuelos promocionVuelos;

    @Autowired
    private EntityManager entityManager;

    public PromocionVuelosController(VueloRepositorio vueloRepositorio) {
        this.vueloRepositorio = vueloRepositorio;

    }

    @GetMapping("generar-promociones")
    public List<Vuelo> generarPromociones() {
        return promocionVuelos.genererVuelos();
    }

    @GetMapping(path = "origen/{ciudadOrigen}")
    public List<Vuelo> listarVueloOrigen(@PathVariable("ciudadOrigen") String ciudadOrigen){
        vueloRespuesta = new VueloRespuesta();
        List<Vuelo> vuelos;
        vuelos = vueloRepositorio.findVuelosByVueloOrigen(ciudadOrigen.toUpperCase());
        return vuelos;
    }

    @GetMapping(path = "destino/{ciudadDestino}")
    public ResponseEntity<VueloRespuesta> listarVuelos(@PathVariable("ciudadDestino") String ciudadDestino){

        Optional<Vuelo> vuelo;
        vueloRespuesta = new VueloRespuesta();
        vuelo = Optional.ofNullable(vueloRepositorio.findVueloByVueloDestino(ciudadDestino.toUpperCase()));


        if(vuelo.isPresent()){
            vueloRespuesta.setPrecio(vuelo.get().getVueloPrecio());
            vueloRespuesta.setClase(vuelo.get().getVueloClase());
            vueloRespuesta.setCodCiudadOrigen(vuelo.get().getVueloOrigen());
            vueloRespuesta.setCodCiudadDestino(vuelo.get().getVueloDestino());
            vueloRespuesta.setFecha(vuelo.get().getVueloFecha());
        }
        return ResponseEntity.ok(vueloRespuesta);

       }
}