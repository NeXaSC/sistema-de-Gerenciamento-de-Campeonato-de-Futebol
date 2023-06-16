package domain.repository;

import domain.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer> {
    Optional<Estadio> findByNome(String nome);

    Optional<Estadio> findByEndereco(String endereco);
}
