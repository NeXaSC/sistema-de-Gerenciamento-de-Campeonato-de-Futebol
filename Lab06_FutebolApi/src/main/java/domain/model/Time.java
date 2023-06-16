package domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Time {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores = new ArrayList<>();

    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL)
    private Estadio estadio;

    @ManyToMany(mappedBy = "times")
    private List<Campeonato> campeonatos = new ArrayList<>();

    @OneToMany(mappedBy = "timeMandante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partida> partidasComoMandante = new ArrayList<>();

    @OneToMany(mappedBy = "timeVisitante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partida> partidasComoVisitante = new ArrayList<>();

}