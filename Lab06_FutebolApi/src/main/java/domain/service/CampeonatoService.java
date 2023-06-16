package domain.service;

import domain.model.Campeonato;
import domain.repository.CampeonatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CampeonatoService {

    private final CampeonatoRepository repository;

    public Iterable<Campeonato> todos() {
        return repository.findAll();
    }

    public Optional<Campeonato> buscaPor(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Campeonato salva(Campeonato campeonato) {
        return repository.save(campeonato);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteCampeonatoCom(Integer id) {
        return !repository.existsById(id);
    }

    public Page<Campeonato> buscaPaginada(Pageable page) {
        return repository.findAll(page);
    }


}