package br.edu.ifam.turismo.hotel_service.repository;

import br.edu.ifam.turismo.hotel_service.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<Cidade> findByCodigoIBGE(String codigoIBGE);
}
