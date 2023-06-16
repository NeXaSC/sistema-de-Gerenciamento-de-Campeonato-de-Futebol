package domain.service;

import domain.model.Time;
import domain.repository.TimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TimeService {

    private final TimeRepository repository;

    public Iterable<Time> todos() {
        return repository.findAll();
    }

    public Optional<Time> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public Iterable<Time> buscaPor(String nome) {
        return repository.findByNomeContaining(nome);
    }

    @Transactional
    public Time salva(Time time) {
        return repository.save(time);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteTimeCom(Integer id) {
        return !repository.existsById(id);
    }

    public Page<Time> buscaPaginada(Pageable page) {
        return repository.findAll(page);
    }

    public Page<Time> buscaPor(String nome, Pageable page) {
        return repository.findByNomeContaining(nome, page);
    }
}
