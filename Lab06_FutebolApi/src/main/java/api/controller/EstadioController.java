package api.controller;

import domain.model.Estadio;
import domain.service.EstadioService;
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
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioService service;

    @GetMapping
    public Iterable<Estadio> lista() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscaPor(@PathVariable Integer id) {
        Optional<Estadio> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estadio> cadastro(@RequestBody @Valid Estadio estadio) {
        Estadio estadioSalvo = service.salva(estadio);
        return ResponseEntity.created(URI.create("/estadios/" + estadioSalvo.getId()))
                .body(estadioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadio> atualiza(@PathVariable Integer id,
                                            @RequestBody @Valid Estadio estadio) {
        Optional<Estadio> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            estadio.setId(id);
            Estadio estadioAtualizado = service.salva(estadio);
            return ResponseEntity.ok(estadioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Estadio> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paginacao")
    public Page<Estadio> listaPaginada(Pageable pageable) {
        return service.buscaPaginada(pageable);
    }

}
