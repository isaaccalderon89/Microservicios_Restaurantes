import com.neoris.gestionrestaurante.entities.Reserva;
import com.neoris.gestionrestaurante.infrastructure.controller.ReservaController;
import com.neoris.gestionrestaurante.usecases.reserva.CreateReservaUseCase;
import com.neoris.gestionrestaurante.usecases.reserva.FindAllReservaUseCase;
import com.neoris.gestionrestaurante.usecases.reserva.UpdateReservaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ReservasControllerTest {

    @Mock
    FindAllReservaUseCase findAllReservaUseCase;
    @Mock
    CreateReservaUseCase createReservaUseCase;
    @Mock
    UpdateReservaUseCase updateReservaUseCase;


    @InjectMocks
    ReservaController reservaController;

    List<Reserva> reservas;

    Reserva reserva;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll(){
        when(findAllReservaUseCase.findAll()).thenReturn(reservas);
        ResponseEntity<List<Reserva>> result =reservaController.findAll();
        assertEquals(reservas,result.getBody());
    }

    @Test
    void testCreate() {
        Reserva reserva = new Reserva();
        Reserva newReserva = new Reserva();
        when(createReservaUseCase.create(any(Reserva.class))).thenReturn(newReserva);
        ResponseEntity<Reserva> response = reservaController.create(reserva);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newReserva, response.getBody());
    }

    @Test
    void testCreateException() {
        Reserva reserva = new Reserva();
        when(createReservaUseCase.create(any(Reserva.class))).thenThrow(new RuntimeException());
        ResponseEntity<Reserva> response = reservaController.create(reserva);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    void testUpdate() {

        Integer id = 1;
        Reserva reserva = new Reserva();
        Reserva updatedReserva = new Reserva();
        when(updateReservaUseCase.update(eq(id), any(Reserva.class))).thenReturn(updatedReserva);
        ResponseEntity<Reserva> response = reservaController.update(id, reserva);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedReserva, response.getBody());
    }

    @Test
    void testUpdateException() {
        Integer id = 1;
        Reserva reserva = new Reserva();
        when(updateReservaUseCase.update(eq(id), any(Reserva.class))).thenThrow(new RuntimeException());
        ResponseEntity<Reserva> response = reservaController.update(id, reserva);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }


}
