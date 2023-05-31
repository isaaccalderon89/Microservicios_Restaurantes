package com.neoris.gestionrestaurante.infrastructure.repository.restaurante.jpa;

import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteJpaRespository extends JpaRepository<InMemoryRestauranteEntity, Integer> {
    @Query("SELECT d FROM InMemoryRestauranteEntity d WHERE d.disponible = :disponible")
    List<InMemoryRestauranteEntity> findByDisponibilidad(@Param("disponible")Boolean disponible);
    @Query("SELECT c FROM InMemoryRestauranteEntity c WHERE c.tipoCocina = :comida")
    List<InMemoryRestauranteEntity> findByTipoComida(@Param("comida") String comida);

}
