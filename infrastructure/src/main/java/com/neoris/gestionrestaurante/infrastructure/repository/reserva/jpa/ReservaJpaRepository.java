package com.neoris.gestionrestaurante.infrastructure.repository.reserva.jpa;

import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaJpaRepository extends JpaRepository<InMemoryReservaEntity, Integer> {
}
