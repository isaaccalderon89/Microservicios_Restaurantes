package com.neoris.gestionrestaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * Aqui tenemos la clase de negocio con anotaciones lombok para obtener el constructor con parametros,
 * constructor sin parametros, getters and setters.
 * @Author Isaac Calderón
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {

    private Integer idReserva;
    private Integer idRestaurante;
    private LocalDateTime fecha;
    private String nombreCliente;
    private String telefonoCliente;

}
