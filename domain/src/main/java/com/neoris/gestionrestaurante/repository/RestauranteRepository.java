package com.neoris.gestionrestaurante.repository;

import com.neoris.gestionrestaurante.entities.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    /**
     * Metodo que devuelve una lista con todas los restaurantes
     * @return lista con todas los restaurantes
     */
    List<Restaurante> findAll();

    /**
     * Metodo que permite buscar una lista de restaurantes según su disponibilidad
     * @param disponible boolean donde True es si esta disponible, false en caso de que no este disponible
     * @return
     */
    List<Restaurante> findByDisponibilidad(Boolean disponible);

    /**
     * Metodo para encontrar restaurantes por el tipo de comida.
     * @param comida
     * @return una lista con los diferentes tipos de comida.
     */
    List<Restaurante> findByTipoComida(String comida);


}
