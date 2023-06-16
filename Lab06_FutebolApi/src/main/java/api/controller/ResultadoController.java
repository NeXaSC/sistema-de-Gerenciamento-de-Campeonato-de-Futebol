package api.controller;

import domain.model.Resultado;
import domain.service.ResultadoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    private final ResultadoService service;

    @GetMapping
    public Iterable<Resultado> todos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> buscaPorId(@PathVariable Integer id) {
        Optional<Resultado> optional = service.buscarPorId(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Resultado> cadastro(@RequestBody @Valid Resultado resultado) {
        Resultado resultadoSalvo = service.salvar(resultado);
        return ResponseEntity.created(URI.create("/resultados/" + resultadoSalvo.getId()))
                .body(resultadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> atualiza(@PathVariable Integer id,
                                              @RequestBody @Valid Resultado resultado) {
        Optional<Resultado> optional = service.buscarPorId(id);

        if (optional.isPresent()) {
            resultado.setId(id);
            Resultado resultadoAtualizado = service.salvar(resultado);
            return ResponseEntity.ok(resultadoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Resultado> optional = service.buscarPorId(id);

        if (optional.isPresent()) {
            service.removerPorId(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paginacao")
    public Page<Resultado> listaPaginada(Pageable pageable) {
        return service.buscarPaginado(pageable);
    }
}