package com.neoris.gestionrestaurante.usecases.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;

import java.util.List;

public interface FindAllReservaUseCase {
    List<Reserva> findAll();
}
