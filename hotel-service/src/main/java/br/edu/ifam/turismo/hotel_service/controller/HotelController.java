
package br.edu.ifam.turismo.hotel_service.controller;

import br.edu.ifam.turismo.hotel_service.model.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {


    private static final List<Hotel> HOTEIS_MOCK = List.of(

            new Hotel(Long.valueOf(1),
                    "Tropical Executive Hotel",
                    "Manaus",
                    new BigDecimal("450.00"),
                    4,
                    true
            ),

            new Hotel(
                    Long.valueOf(2),
                    "Hotel Juma Ópera",
                    "Manaus",
                    new BigDecimal("890.00"),
                    5,
                    true
            ),

            new Hotel(
                    Long.valueOf(3),
                    "Blue Tree Premium",
                    "Manaus",
                    new BigDecimal("380.00"),
                    4,
                    false
            ),

            new Hotel(
                    Long.valueOf(4),
                    "Ibis Manaus Aeroporto",
                    "Manaus",
                    new BigDecimal("260.00"),
                    3,
                    true
            )
    );

    // Endpoint para consultar todos os hotéis
    @GetMapping
    public ResponseEntity<List<Hotel>> listarTodos() {
        return ResponseEntity.ok(HOTEIS_MOCK);
    }
}
