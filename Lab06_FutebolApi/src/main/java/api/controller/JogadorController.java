package api.controller;

import domain.model.Jogador;
import domain.service.JogadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    @GetMapping
    public Iterable<Jogador> lista() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscaPor(@PathVariable Integer id) {
        Optional<Jogador> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Jogador> cadastro(@RequestBody @Valid Jogador jogador,
                                            UriComponentsBuilder builder) {

        final Jogador jogadorSalvo = service.salva(jogador);
        final URI uri = builder
                .path("/jogadores/{id}")
                .buildAndExpand(jogadorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(jogadorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualiza(@PathVariable Integer id,
                                            @RequestBody @Valid Jogador jogador) {
        Optional<Jogador> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            jogador.setId(id);
            Jogador jogadorAtualizado = service.salva(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Jogador> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Jogador> atualizacaoParcial(@PathVariable Integer id,
                                                      @RequestBody Map<String, Object> campos) {
        Optional<Jogador> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            Jogador jogadorAtual = optional.get();

            merge(campos, jogadorAtual);
            return this.atualiza(id, jogadorAtual);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Jogador jogadorDestino) {
        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Jogador.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, valorPropriedade);

            ReflectionUtils.setField(field, jogadorDestino, novoValor);
        });
    }
}