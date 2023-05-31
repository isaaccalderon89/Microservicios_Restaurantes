package com.neoris.gestionrestaurante.infrastructure.controller;

import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.usecases.restaurante.FindAllRestaurantesUseCase;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByDisponibilidadUseCase;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByTipoComidaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    private FindAllRestaurantesUseCase findAllRestaurantesUseCase;

    private FindByDisponibilidadUseCase findByDisponibilidadUseCase;

    private FindByTipoComidaUseCase findByTipoComidaUseCase;


    public RestauranteController(FindAllRestaurantesUseCase findAllRestaurantesUseCase, FindByDisponibilidadUseCase findByDisponibilidadUseCase, FindByTipoComidaUseCase findByTipoComidaUseCase) {
        this.findAllRestaurantesUseCase = findAllRestaurantesUseCase;
        this.findByDisponibilidadUseCase = findByDisponibilidadUseCase;
        this.findByTipoComidaUseCase = findByTipoComidaUseCase;
    }

    @GetMapping(value="")
    public ResponseEntity<List<Restaurante>> findAll(){
        return ResponseEntity.ok(findAllRestaurantesUseCase.findAll());
    }

    @GetMapping(value="/disponibilidad/{s}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurante>> findByDisponibilidad(@PathVariable String s){
        try{
            List<Restaurante> newRestaurantes = findByDisponibilidadUseCase.findByDisponibilidad(Boolean.valueOf(s));
            return ResponseEntity.ok(newRestaurantes);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value="/comida/{comida}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurante>> findByTipoComida(@PathVariable("comida") String comida){
        try{
            List<Restaurante> newRestaurante = findByTipoComidaUseCase.findByTipoComida(comida);
            return ResponseEntity.ok(newRestaurante);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
