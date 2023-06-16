package api.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JogadorNomeResponse {
    private Integer jogadorId;
    private String nome;
    private LocalDate dataDeNascimento;
    private Float altura;


}
