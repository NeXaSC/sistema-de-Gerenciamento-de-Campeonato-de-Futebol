package api.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoResponse {
    private Integer resultadoId;
    private Integer numGolsMandante;
    private Integer numGolsVisitante;

}