package domain.service;

import domain.repository.EstadioRepository;
import lombok.AllArgsConstructor;
import domain.model.Estadio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EstadioService {

    private final EstadioRepository repository;

    public Iterable<Estadio> todos() {
        return repository.findAll();
    }

    public Optional<Estadio> buscaPor(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Estadio salva(Estadio estadio) {
        return repository.save(estadio);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteEstadioCom(Integer id) {
        return !repository.existsById(id);
    }

    public Page<Estadio> buscaPaginada(Pageable page) {
        return repository.findAll(page);
    }


}