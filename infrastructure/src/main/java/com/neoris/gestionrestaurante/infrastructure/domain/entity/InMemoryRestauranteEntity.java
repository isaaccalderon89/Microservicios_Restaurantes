package com.neoris.gestionrestaurante.infrastructure.domain.entity;

import com.neoris.gestionrestaurante.entities.Reserva;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RESTAURANTES")
public class InMemoryRestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RESTAURANTES")
    private Integer idRestaurante;
    @Column(name="NAME")
    private String nombre;
    @Column(name="UBICACION")
    private String ubicacion;
    @Column(name="TIPO_COCINA")
    private String tipoCocina;
    @Column(name = "DISPONIBLE")
    private Boolean disponible;

    public InMemoryRestauranteEntity() {
    }

    public InMemoryRestauranteEntity(Integer idRestaurante, String nombre, String ubicacion, String tipoCocina, Boolean disponible) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoCocina = tipoCocina;
        this.disponible = disponible;
    }

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
