package com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryReservaEntity;

import com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.InMemoryEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface InMemoryReservaMapper extends InMemoryEntityMapper<Reserva, InMemoryReservaEntity> {

    @Override
    @Mapping(source="inMemoryRestauranteEntity.idRestaurante", target = "idRestaurante")
    Reserva toDomainEntity(InMemoryReservaEntity inMemoryReservaEntity);
    @Override
    @Mapping(source="idRestaurante", target = "inMemoryRestauranteEntity.idRestaurante")
    InMemoryReservaEntity toInMemoryEntity(Reserva domainEntity);
}
