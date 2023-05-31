package com.neoris.gestionrestaurante.infrastructure.repository.reserva;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryReservaEntity;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryRestauranteEntity;
import com.neoris.gestionrestaurante.infrastructure.mapper.inmemory.reserva.InMemoryReservaMapper;
import com.neoris.gestionrestaurante.infrastructure.repository.reserva.jpa.ReservaJpaRepository;
import com.neoris.gestionrestaurante.infrastructure.repository.restaurante.jpa.RestauranteJpaRespository;
import com.neoris.gestionrestaurante.repository.ReservasRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaEntityRepository implements ReservasRepository {

    private ReservaJpaRepository reservaJpaRepository;

    private RestauranteJpaRespository restauranteJpaRespository;
    private InMemoryReservaMapper inMemoryReservaMapper;

    public ReservaEntityRepository(ReservaJpaRepository reservaJpaRepository, RestauranteJpaRespository restauranteJpaRespository, InMemoryReservaMapper inMemoryReservaMapper) {
        this.reservaJpaRepository = reservaJpaRepository;
        this.restauranteJpaRespository = restauranteJpaRespository;
        this.inMemoryReservaMapper = inMemoryReservaMapper;
    }

    @Override
    public List<Reserva> findAll() {
        return inMemoryReservaMapper.toDomainEntityList(reservaJpaRepository.findAll());
    }

    @Override
    public Reserva create(Reserva reserva) {
        InMemoryReservaEntity entity = inMemoryReservaMapper.toInMemoryEntity(reserva);
        Optional<InMemoryRestauranteEntity> restaurante = restauranteJpaRespository.findById(reserva.getIdRestaurante());
        if(restaurante.isPresent()){
            entity.setInMemoryRestauranteEntity(restaurante.get());
            return inMemoryReservaMapper.toDomainEntity(reservaJpaRepository.save(entity));
        } else {
            throw new NotFoundException("Restaurante no encontrado");
        }

    }

    @Override
    public Reserva update(Integer id, Reserva reserva) {
        InMemoryReservaEntity entity = inMemoryReservaMapper.toInMemoryEntity(reserva);
        Optional<InMemoryReservaEntity> optionalEntity = reservaJpaRepository.findById(id);
        if(optionalEntity.isPresent()){
            entity.setIdReserva(id);
            return inMemoryReservaMapper.toDomainEntity(reservaJpaRepository.save(entity));
        } else{
            throw new NotFoundException("Reserva no encontrada");
        }
    }
}
