package domain.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import domain.model.Resultado;
import domain.repository.ResultadoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ResultadoService {

    private final ResultadoRepository repository;

    public Optional<Resultado> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Resultado> buscarTodos() {
        return repository.findAll();
    }

    public Page<Resultado> buscarPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Resultado salvar(Resultado resultado) {
        return repository.save(resultado);
    }

    @Transactional
    public void removerPorId(Integer id) {
        repository.deleteById(id);
    }

    public boolean existeResultadoComId(Integer id) {
        return repository.existsById(id);
    }
}