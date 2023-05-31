package com.neoris.gestionrestaurante.useCase.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.repository.RestauranteRepository;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByTipoComidaUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByTipoComidaUseCaseImpl implements FindByTipoComidaUseCase {

    private RestauranteRepository restauranteRepository;

    public FindByTipoComidaUseCaseImpl(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public List<Restaurante> findByTipoComida(String comida) {
        return restauranteRepository.findByTipoComida(comida);
    }
}
