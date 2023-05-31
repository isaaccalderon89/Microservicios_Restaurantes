package com.neoris.gestionrestaurante.usecases.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;

public interface UpdateReservaUseCase {
    Reserva update(Integer id, Reserva reserva);
}
