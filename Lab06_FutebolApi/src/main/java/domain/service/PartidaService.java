package domain.service;


import lombok.AllArgsConstructor;
import domain.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import domain.repository.PartidaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PartidaService {

    private final PartidaRepository repository;

    public Iterable<Partida> todas() {
        return repository.findAll();
    }

    public Optional<Partida> buscaPor(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Partida salva(Partida partida) {
        return repository.save(partida);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExistePartidaCom(Integer id) {
        return !repository.existsById(id);
    }

    public Page<Partida> buscaPaginada(Pageable page) {
        return repository.findAll(page);
    }


}