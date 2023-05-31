package com.neoris.gestionrestaurante.usecases.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;

import java.util.List;

public interface FindByDisponibilidadUseCase {

    List<Restaurante> findByDisponibilidad(Boolean disponible);
}
