package api.dto.input;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidaRequest {
    @NotNull
    private LocalDate data;

}