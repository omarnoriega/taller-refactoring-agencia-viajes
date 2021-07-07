package com.ceiba.refactor.agenciaviajes;

import com.ceiba.refactor.agenciaviajes.modelo.Vuelo;
import com.ceiba.refactor.agenciaviajes.modelo.VueloRespuesta;
import com.ceiba.refactor.agenciaviajes.repositorio.VueloRepositorio;
import com.ceiba.refactor.agenciaviajes.servicio.PromocionVuelosController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PromocionVuelosTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void aplicarTarifaOk() throws Exception {

        final ResultActions result = mockMvc.perform(get("/vuelos/generar-promociones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                //Clase Economica ARMENIA
                .andExpect(jsonPath("$[0].vueloId", is(1)))
                .andExpect(jsonPath("$[0].vueloOrigen", is("BOG")))
                .andExpect(jsonPath("$[0].vueloDestino", is("AXM")))
                .andExpect(jsonPath("$[0].vueloClase", is("Economica")))
                .andExpect(jsonPath("$[0].vueloPrecio", is(68000.0)))

                //Clase Economica PEREIRA
                .andExpect(jsonPath("$[1].vueloId", is(2)))
                .andExpect(jsonPath("$[1].vueloOrigen", is("BOG")))
                .andExpect(jsonPath("$[1].vueloDestino", is("PEI")))
                .andExpect(jsonPath("$[1].vueloClase", is("Economica")))
                .andExpect(jsonPath("$[1].vueloPrecio", is(48000.0)))

                //Clase Economica MANIZALES
                .andExpect(jsonPath("$[2].vueloId", is(3)))
                .andExpect(jsonPath("$[2].vueloOrigen", is("BOG")))
                .andExpect(jsonPath("$[2].vueloDestino", is("MNZ")))
                .andExpect(jsonPath("$[2].vueloClase", is("Economica")))
                .andExpect(jsonPath("$[2].vueloPrecio", is(77000.0)));

        System.out.println(result.andReturn().getResponse().getContentAsString());
    }


    @Test
    public void listarVuelosOk() {

        VueloRepositorio vueloRepositoryMock = Mockito.mock(VueloRepositorio.class);

        PromocionVuelosController promocionVuelosController = new PromocionVuelosController(vueloRepositoryMock);

        Vuelo mockVuelo = new Vuelo("MED", "BOG", "Economica", 120000.0, new Date());

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(mockVuelo);

        //Tan pronto se haga una petición a la BD, se reemplace con el objeto mockVuelo
        Mockito.when(vueloRepositoryMock.findVueloByVueloDestino("BOG"))
               .thenReturn(mockVuelo);

        ResponseEntity<VueloRespuesta> responseEntity;
        responseEntity = promocionVuelosController.listarVuelos("BOG");
        System.out.println("Ciudad Destino:"+ responseEntity.getBody().getCodCiudadDestino());
        System.out.println("Ciudad Origen:"+ responseEntity.getBody().getCodCiudadOrigen());
        System.out.println("Fecha:"+ responseEntity.getBody().getFecha());

        Assertions.assertEquals("BOG", responseEntity.getBody().getCodCiudadDestino());

    }
}