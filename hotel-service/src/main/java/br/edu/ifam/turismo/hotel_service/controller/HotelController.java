package br.edu.ifam.turismo.hotel_service.controller;

import br.edu.ifam.turismo.hotel_service.dto.HotelRequestDTO;
import br.edu.ifam.turismo.hotel_service.dto.HotelResponseDTO;
import br.edu.ifam.turismo.hotel_service.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> listarTodos() {
        return ResponseEntity.ok(hotelService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<HotelResponseDTO> inserir(
            @RequestBody HotelRequestDTO request) {

        HotelResponseDTO hotelSalvo = hotelService.inserir(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelSalvo);
    }
}
