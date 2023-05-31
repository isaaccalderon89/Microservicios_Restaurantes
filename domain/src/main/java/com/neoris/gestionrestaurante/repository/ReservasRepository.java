package com.neoris.gestionrestaurante.repository;

import com.neoris.gestionrestaurante.entities.Reserva;

import java.util.List;

public interface ReservasRepository {
    List<Reserva> findAll();

    Reserva create(Reserva reserva);

    Reserva update(Integer id,Reserva reserva);


}
