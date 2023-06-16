package domain.service;

import domain.model.Jogador;
import lombok.AllArgsConstructor;
import domain.repository.JogadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JogadorService {

    private final JogadorRepository repository;

    public Iterable<Jogador> todos() {
        return repository.findAll();
    }

    public Optional<Jogador> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public Iterable<Jogador> buscaPor(String nome) {
        return repository.findByNomeContaining(nome);
    }

    @Transactional
    public Jogador salva(Jogador jogador) {
        return repository.save(jogador);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteJogadorCom(Integer id) {
        return !repository.existsById(id);
    }

    public Page<Jogador> buscaPaginada(Pageable page) {
        return repository.findAll(page);
    }

    public Page<Jogador> buscaPor(String nome, Pageable page) {
        return repository.findByNomeContaining(nome, page);
    }
}
