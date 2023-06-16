package domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Resultado {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Partida partida;

    @NotNull
    private Integer numGolsMandante;

    @NotNull
    private Integer numGolsVisitante;

    public Integer getPontuacaoMandante() {
        return numGolsMandante;
    }

    public Integer getPontuacaoVisitante() {
        return numGolsVisitante;
    }

    public boolean jogoSaiuEmpatado() {
        return numGolsMandante.equals(numGolsVisitante);
    }

}