package com.neoris.gestionrestaurante.useCase.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.repository.RestauranteRepository;
import com.neoris.gestionrestaurante.usecases.restaurante.FindAllRestaurantesUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllRestaurantesImpl implements FindAllRestaurantesUseCase {

    private RestauranteRepository restauranteRepository;

    public FindAllRestaurantesImpl(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
}
