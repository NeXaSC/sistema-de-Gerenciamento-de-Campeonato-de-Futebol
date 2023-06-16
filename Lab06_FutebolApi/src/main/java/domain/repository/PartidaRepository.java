package domain.repository;

import domain.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
    List<Partida> findByData(LocalDate data);
}