package com.neoris.gestionrestaurante.useCase.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.repository.ReservasRepository;
import com.neoris.gestionrestaurante.usecases.reserva.CreateReservaUseCase;
import org.springframework.stereotype.Component;

@Component
public class CreateReservaUseCaseImpl implements CreateReservaUseCase {

    private ReservasRepository reservasRepository;

    public CreateReservaUseCaseImpl(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    @Override
    public Reserva create(Reserva reserva) {
        return reservasRepository.create(reserva);
    }
}
