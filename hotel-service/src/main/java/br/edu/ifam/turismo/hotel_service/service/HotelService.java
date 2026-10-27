package br.edu.ifam.turismo.hotel_service.service;

import br.edu.ifam.turismo.hotel_service.dto.HotelRequestDTO;
import br.edu.ifam.turismo.hotel_service.dto.HotelResponseDTO;
import br.edu.ifam.turismo.hotel_service.entity.Cidade;
import br.edu.ifam.turismo.hotel_service.entity.Hotel;
import br.edu.ifam.turismo.hotel_service.repository.CidadeRepository;
import br.edu.ifam.turismo.hotel_service.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final CidadeRepository cidadeRepository;

    public HotelService(HotelRepository hotelRepository, CidadeRepository cidadeRepository) {
        this.hotelRepository = hotelRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public List<HotelResponseDTO> listarTodos() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelResponseDTO::new)
                .toList();
    }

    public HotelResponseDTO inserir(HotelRequestDTO request) {
        Cidade cidadeEncontrada = cidadeRepository
                .findByCodigoIBGE(request.getCodigoIBGE())
                .orElseThrow(() -> new RuntimeException(
                        "Cidade não encontrada no sistema com o código fornecido: "
                                + request.getCodigoIBGE()));

        Hotel hotel = request.build(cidadeEncontrada);

        Hotel hotelSalvo = hotelRepository.save(hotel);

        return new HotelResponseDTO(hotelSalvo);
    }
}
