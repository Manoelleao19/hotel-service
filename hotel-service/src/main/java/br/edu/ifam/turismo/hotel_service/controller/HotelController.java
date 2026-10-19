
package br.edu.ifam.turismo.hotel_service.controller;

import br.edu.ifam.turismo.hotel_service.model.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    // Lista mutável em memória com os quatro hotéis iniciais
    private static final List<Hotel> HOTEIS = new ArrayList<>(List.of(
            new Hotel(1L, "Tropical Executive Hotel", "Manaus",
                    new BigDecimal("450.00"), 4, true),
            new Hotel(2L, "Hotel Juma Ópera", "Manaus",
                    new BigDecimal("890.00"), 5, true),
            new Hotel(3L, "Blue Tree Premium", "Manaus",
                    new BigDecimal("380.00"), 4, false),
            new Hotel(4L, "Ibis Manaus Aeroporto", "Manaus",
                    new BigDecimal("260.00"), 3, true)
    ));

    // 1. Consulta todos os hotéis: GET /hoteis
    @GetMapping
    public ResponseEntity<List<Hotel>> listarTodos() {
        return ResponseEntity.ok(HOTEIS);
    }

    // 2. Consulta um hotel pelo ID: GET /hoteis/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable Long id) {
        for (Hotel hotel : HOTEIS) {
            if (hotel.getId().equals(id)) {
                return ResponseEntity.ok(hotel);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // 3. Cadastra um hotel: POST /hoteis
    @PostMapping
    public ResponseEntity<Hotel> cadastrar(@RequestBody Hotel novoHotel) {
        long novoId = HOTEIS.size() + 1L;
        novoHotel.setId(novoId);
        HOTEIS.add(novoHotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoHotel);
    }

    // 4. Remove um hotel pelo ID: DELETE /hoteis/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        boolean removido = HOTEIS.removeIf(
                hotel -> hotel.getId().equals(id)
        );

        if (removido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
