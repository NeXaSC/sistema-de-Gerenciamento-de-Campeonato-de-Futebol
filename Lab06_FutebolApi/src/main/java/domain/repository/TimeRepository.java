package domain.repository;

import domain.model.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

    List<Time> findByNomeContaining(String nome);
    Page<Time> findByNomeContaining(@Param("nome") String nome, Pageable pageable);

}