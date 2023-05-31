import com.neoris.gestionrestaurante.entities.Restaurante;
import com.neoris.gestionrestaurante.infrastructure.controller.RestauranteController;
import com.neoris.gestionrestaurante.usecases.restaurante.FindAllRestaurantesUseCase;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByDisponibilidadUseCase;
import com.neoris.gestionrestaurante.usecases.restaurante.FindByTipoComidaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;

public class RestauranteControllerTest {

    @Mock
    FindAllRestaurantesUseCase findAllRestaurantesUseCase;
    @Mock
    FindByDisponibilidadUseCase findByDisponibilidadUseCase;
    @Mock
    FindByTipoComidaUseCase findByTipoComidaUseCase;

    @InjectMocks
    RestauranteController restauranteController;

    List<Restaurante> restaurantes;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testfindAll(){
        when(findAllRestaurantesUseCase.findAll()).thenReturn(restaurantes);
        ResponseEntity<List <Restaurante>> result = restauranteController.findAll();
        assertEquals(restaurantes,result.getBody());
    }

    @Test
    void testFindDisponibilidadT(){
        boolean disponibilidad = true;
        when(findByDisponibilidadUseCase.findByDisponibilidad(anyBoolean())).thenReturn(restaurantes);

        ResponseEntity<List<Restaurante>> response = restauranteController.findByDisponibilidad(String.valueOf(disponibilidad));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurantes, response.getBody());
    }

    @Test
    void testFindByDisponibilidadException() {
        boolean disponibilidad = true;
        when(findByDisponibilidadUseCase.findByDisponibilidad(anyBoolean())).thenThrow(new RuntimeException());
        ResponseEntity<List<Restaurante>> response = restauranteController.findByDisponibilidad(String.valueOf(disponibilidad));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testFindByTipoComida(){
        String tipoCocina = "Comida venezolana";
        when(findByTipoComidaUseCase.findByTipoComida(tipoCocina)).thenReturn(restaurantes);
        ResponseEntity<List<Restaurante>> response = restauranteController.findByTipoComida(tipoCocina);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurantes, response.getBody());
    }

    @Test
    void testFindByTipoComidaException() {
        String tipoCocina = "Comida venezolana";
        when(findByTipoComidaUseCase.findByTipoComida(tipoCocina)).thenThrow(new RuntimeException());
        ResponseEntity<List<Restaurante>> response = restauranteController.findByTipoComida(tipoCocina);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}
