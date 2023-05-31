package com.neoris.gestionrestaurante.infrastructure.repository.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryRestauranteEntity;
import com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.restaurante.InMemoryRestauranteMapper;
import com.neoris.gestionrestaurante.infrastructure.repository.restaurante.jpa.RestauranteJpaRespository;
import com.neoris.gestionrestaurante.repository.RestauranteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestauranteEntityRepository implements RestauranteRepository {

    private RestauranteJpaRespository restauranteJpaRespository;

    private InMemoryRestauranteMapper inMemoryRestauranteMapper;


    public RestauranteEntityRepository(RestauranteJpaRespository restauranteJpaRespository, InMemoryRestauranteMapper inMemoryRestauranteMapper) {
        this.restauranteJpaRespository = restauranteJpaRespository;
        this.inMemoryRestauranteMapper = inMemoryRestauranteMapper;
    }

    @Override
    public List<Restaurante> findAll() {
        List<InMemoryRestauranteEntity> result = restauranteJpaRespository.findAll();
        return inMemoryRestauranteMapper.toDomainEntityList(restauranteJpaRespository.findAll());
    }

    @Override
    public List<Restaurante> findByDisponibilidad(Boolean disponible) {
        List<InMemoryRestauranteEntity> result = restauranteJpaRespository.findByDisponibilidad(disponible);
        return inMemoryRestauranteMapper.toDomainEntityList(restauranteJpaRespository.findByDisponibilidad(disponible));
    }

    @Override
    public List<Restaurante> findByTipoComida(String comida) {
       List<InMemoryRestauranteEntity> result = restauranteJpaRespository.findByTipoComida(comida);
       return inMemoryRestauranteMapper.toDomainEntityList(restauranteJpaRespository.findByTipoComida(comida));
    }
}
