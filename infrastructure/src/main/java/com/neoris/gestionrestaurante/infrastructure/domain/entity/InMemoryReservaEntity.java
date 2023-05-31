package com.neoris.gestionrestaurante.infrastructure.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVAS")
public class InMemoryReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RESERVA")
    private Integer idReserva;
    @ManyToOne
    @JoinColumn(name = "ID_RESTAURANTES")
    private InMemoryRestauranteEntity inMemoryRestauranteEntity;

    @Column(name="FECHA_RESERVA")
    private LocalDateTime fecha;
    @Column(name="NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(name="TELEFONO_CLIENTE")
    private String telefonoCliente;

    public InMemoryReservaEntity() {
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public InMemoryRestauranteEntity getInMemoryRestauranteEntity() {
        return inMemoryRestauranteEntity;
    }

    public void setInMemoryRestauranteEntity(InMemoryRestauranteEntity inMemoryRestauranteEntity) {
        this.inMemoryRestauranteEntity = inMemoryRestauranteEntity;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}
