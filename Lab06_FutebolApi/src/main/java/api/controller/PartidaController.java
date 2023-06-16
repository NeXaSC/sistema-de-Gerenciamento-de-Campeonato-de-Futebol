package api.controller;

import domain.model.Partida;
import domain.service.PartidaService;
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
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService service;

    @GetMapping
    public Iterable<Partida> lista() {
        return service.todas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscaPor(@PathVariable Integer id) {
        Optional<Partida> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Partida> cadastro(@RequestBody @Valid Partida partida) {
        Partida partidaSalva = service.salva(partida);
        return ResponseEntity.created(URI.create("/partidas/" + partidaSalva.getId()))
                .body(partidaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> atualiza(@PathVariable Integer id,
                                            @RequestBody @Valid Partida partida) {
        Optional<Partida> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            partida.setId(id);
            Partida partidaAtualizada = service.salva(partida);
            return ResponseEntity.ok(partidaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Partida> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paginacao")
    public Page<Partida> listaPaginada(Pageable pageable) {
        return service.buscaPaginada(pageable);
    }

}
