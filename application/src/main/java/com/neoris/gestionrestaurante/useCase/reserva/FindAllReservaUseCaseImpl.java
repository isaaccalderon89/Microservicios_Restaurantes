package com.neoris.gestionrestaurante.useCase.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.repository.ReservasRepository;
import com.neoris.gestionrestaurante.usecases.reserva.FindAllReservaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllReservaUseCaseImpl implements FindAllReservaUseCase {

    private ReservasRepository reservasRepository;

    public FindAllReservaUseCaseImpl(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }


    @Override
    public List<Reserva> findAll() {
        return reservasRepository.findAll();
    }
}
