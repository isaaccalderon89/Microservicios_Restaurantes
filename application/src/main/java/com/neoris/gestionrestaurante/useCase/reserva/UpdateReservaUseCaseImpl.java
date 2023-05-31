package com.neoris.gestionrestaurante.useCase.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.repository.ReservasRepository;
import com.neoris.gestionrestaurante.usecases.reserva.UpdateReservaUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateReservaUseCaseImpl implements UpdateReservaUseCase {

    private ReservasRepository reservasRepository;

    public UpdateReservaUseCaseImpl(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    @Override
    public Reserva update(Integer id, Reserva reserva) {
        return reservasRepository.update(id, reserva);
    }
}
