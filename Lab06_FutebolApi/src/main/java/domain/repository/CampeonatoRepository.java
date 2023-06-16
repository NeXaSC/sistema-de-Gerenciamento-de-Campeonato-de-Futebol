package domain.repository;

import domain.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {

    Optional<Campeonato> findByNome(String nome);

    Optional<Campeonato> findByAno(Integer ano);
}
