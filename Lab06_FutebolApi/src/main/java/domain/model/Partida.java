package domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Partida {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "time_mandante_id")
    private Time timeMandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time timeVisitante;

    @OneToOne
    @JoinColumn(name = "resultado_id")
    private Resultado resultado;


}
