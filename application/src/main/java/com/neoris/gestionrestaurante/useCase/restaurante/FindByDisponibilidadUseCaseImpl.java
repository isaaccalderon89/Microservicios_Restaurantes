package com.neoris.gestionrestaurante.useCase.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.repository.RestauranteRepository;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByDisponibilidadUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByDisponibilidadUseCaseImpl implements FindByDisponibilidadUseCase {
    private RestauranteRepository restauranteRepository;

    public FindByDisponibilidadUseCaseImpl(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }


    @Override
    public List<Restaurante> findByDisponibilidad(Boolean disponible) {
        return restauranteRepository.findByDisponibilidad(disponible);
    }
}
