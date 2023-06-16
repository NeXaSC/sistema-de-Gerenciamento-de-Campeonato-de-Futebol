package domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Campeonato {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotNull
    private Integer ano;

    @ManyToMany
    @JoinTable(name = "campeonato_time",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id"))
    private List<Time> times = new ArrayList<>();

}