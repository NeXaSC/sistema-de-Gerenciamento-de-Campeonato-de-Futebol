package api.dto.output;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PartidaResponse {
    private Integer partidaId;
    private LocalDate data;

}