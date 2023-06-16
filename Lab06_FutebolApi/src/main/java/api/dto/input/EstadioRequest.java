package api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EstadioRequest {
    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String endereco;

}
