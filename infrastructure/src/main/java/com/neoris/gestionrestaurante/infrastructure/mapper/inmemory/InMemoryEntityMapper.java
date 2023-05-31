package com.neoris.gestionrestaurante.infrastructure.mapper.inmemory;

import java.util.List;

public interface InMemoryEntityMapper <DOMAIN_ENTITY, INMEMORY_ENTITY> {
    DOMAIN_ENTITY toDomainEntity(INMEMORY_ENTITY inmemoryEntity);
    INMEMORY_ENTITY toInMemoryEntity(DOMAIN_ENTITY domainEntity);

    List<DOMAIN_ENTITY> toDomainEntityList(List<INMEMORY_ENTITY> inmemoryEntity);
}
