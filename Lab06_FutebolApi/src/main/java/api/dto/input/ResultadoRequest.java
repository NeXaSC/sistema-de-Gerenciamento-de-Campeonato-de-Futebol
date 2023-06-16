package api.dto.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ResultadoRequest {
    @NotNull
    private Integer numGolsMandante;

    @NotNull
    private Integer numGolsVisitante;
}