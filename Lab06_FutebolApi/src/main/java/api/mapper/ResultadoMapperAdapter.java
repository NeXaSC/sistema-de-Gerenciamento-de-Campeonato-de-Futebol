package api.mapper;

import api.dto.input.ResultadoRequest;
import api.dto.output.ResultadoResponse;
import domain.model.Resultado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResultadoMapperAdapter {

    private final ModelMapper modelMapper;

    public ResultadoMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ResultadoResponse toResultadoResponse(Resultado resultado) {
        return modelMapper.map(resultado, ResultadoResponse.class);
    }

    public Resultado toResultado(ResultadoRequest resultadoRequest) {
        return modelMapper.map(resultadoRequest, Resultado.class);
    }
}
