package com.neoris.gestionrestaurante.infrastructure.controller;

import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.infrastructure.domain.entity.InMemoryReservaEntity;
import com.neoris.gestionrestaurante.usecases.reserva.CreateReservaUseCase;
import com.neoris.gestionrestaurante.usecases.reserva.FindAllReservaUseCase;
import com.neoris.gestionrestaurante.usecases.reserva.UpdateReservaUseCase;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    FindAllReservaUseCase findAllReservaUseCase;

    CreateReservaUseCase createReservaUseCase;

    UpdateReservaUseCase updateReservaUseCase;

    public ReservaController(FindAllReservaUseCase findAllReservaUseCase, CreateReservaUseCase createReservaUseCase, UpdateReservaUseCase updateReservaUseCase) {
        this.findAllReservaUseCase = findAllReservaUseCase;
        this.createReservaUseCase = createReservaUseCase;
        this.updateReservaUseCase = updateReservaUseCase;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Reserva>> findAll(){
        return ResponseEntity.ok(findAllReservaUseCase.findAll());
    }

    @PostMapping(value= "/create")
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
        try{
            Reserva newReserva = createReservaUseCase.create(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(newReserva);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Integer id, @RequestBody Reserva reserva){
        try{
            return ResponseEntity.ok(updateReservaUseCase.update(id,reserva));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

