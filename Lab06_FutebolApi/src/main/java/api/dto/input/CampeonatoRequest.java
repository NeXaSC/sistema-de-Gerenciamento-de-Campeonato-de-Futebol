package api.dto.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CampeonatoRequest {
    @NotBlank
    private String nome;

    @NotNull
    private Integer ano;


}