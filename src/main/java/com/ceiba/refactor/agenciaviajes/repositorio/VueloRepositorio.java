package com.ceiba.refactor.agenciaviajes.repositorio;
import com.ceiba.refactor.agenciaviajes.modelo.Vuelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepositorio extends CrudRepository<Vuelo, Long> {
    Vuelo findVueloByVueloDestino (String vueloDestino);
    List<Vuelo> findVuelosByVueloOrigen (String ciudadOrigen);

}
