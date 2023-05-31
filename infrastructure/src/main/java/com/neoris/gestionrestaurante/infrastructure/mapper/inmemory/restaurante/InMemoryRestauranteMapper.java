package com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.restaurante;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryRestauranteEntity;
import com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.InMemoryEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface InMemoryRestauranteMapper extends InMemoryEntityMapper<Restaurante, InMemoryRestauranteEntity> {

    @Override
    Restaurante toDomainEntity(InMemoryRestauranteEntity inmemoryEntity);
}
