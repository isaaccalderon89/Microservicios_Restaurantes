package com.neoris.gestionrestaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Aqui tenemos la clase de negocio con anotaciones lombok para obtener el constructor con parametros,
 * constructor sin parametros, getters and setters.
 * @Author Isaac Calderón
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurante {

    private Integer idRestaurante;
    private String nombre;
    private String ubicacion;
    private String tipoCocina;
    private Boolean disponible;
}
