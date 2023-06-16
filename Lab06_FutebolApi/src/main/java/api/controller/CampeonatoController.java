package api.controller;

import domain.model.Campeonato;
import domain.service.CampeonatoService;
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
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService service;

    @GetMapping
    public Iterable<Campeonato> lista() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> buscaPor(@PathVariable Integer id) {
        Optional<Campeonato> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Campeonato> cadastro(@RequestBody @Valid Campeonato campeonato) {
        Campeonato campeonatoSalvo = service.salva(campeonato);
        return ResponseEntity.created(URI.create("/campeonatos/" + campeonatoSalvo.getId()))
                .body(campeonatoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> atualiza(@PathVariable Integer id,
                                               @RequestBody @Valid Campeonato campeonato) {
        Optional<Campeonato> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            campeonato.setId(id);
            Campeonato campeonatoAtualizado = service.salva(campeonato);
            return ResponseEntity.ok(campeonatoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Campeonato> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/paginacao")
    public Page<Campeonato> listaPaginada(Pageable pageable) {
        return service.buscaPaginada(pageable);
    }

}
