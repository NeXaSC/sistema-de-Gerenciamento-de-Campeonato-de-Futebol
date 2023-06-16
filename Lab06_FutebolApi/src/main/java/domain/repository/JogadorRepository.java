package domain.repository;

import domain.model.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    List<Jogador> findByNomeContaining(String nome);
    Page<Jogador> findByNomeContaining(@Param("nome") String nome, Pageable pageable);

    Page<Jogador> findAll(Pageable pageable);
}
