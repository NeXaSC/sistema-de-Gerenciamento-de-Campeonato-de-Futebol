package api.controller;

import domain.model.Time;
import domain.service.TimeService;
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
@RequestMapping("/times")
public class TimeController {

    private final TimeService service;

    @GetMapping
    public Iterable<Time> lista() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscaPor(@PathVariable Integer id) {
        Optional<Time> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Time> cadastro(@RequestBody @Valid Time time) {
        Time timeSalvo = service.salva(time);
        return ResponseEntity.created(URI.create("/times/" + timeSalvo.getId()))
                .body(timeSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualiza(@PathVariable Integer id,
                                         @RequestBody @Valid Time time) {
        Optional<Time> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            time.setId(id);
            Time timeAtualizado = service.salva(time);
            return ResponseEntity.ok(timeAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Time> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paginacao")
    public Page<Time> listaPaginada(Pageable pageable) {
        return service.buscaPaginada(pageable);
    }

    @GetMapping("/busca")
    public Page<Time> buscaPor(@RequestParam(required = false) String nome, Pageable pageable) {
        if (nome == null) {
            return service.buscaPaginada(pageable);
        } else {
            return service.buscaPor(nome, pageable);
        }
    }

}
