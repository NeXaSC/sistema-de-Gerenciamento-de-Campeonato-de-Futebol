package api.mapper;

import api.dto.input.EstadioRequest;
import api.dto.output.EstadioResponse;
import domain.model.Estadio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstadioMapperAdapter {

    private final ModelMapper modelMapper;

    public EstadioMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EstadioResponse toEstadioResponse(Estadio estadio) {
        return modelMapper.map(estadio, EstadioResponse.class);
    }

    public Estadio toEstadio(EstadioRequest estadioRequest) {
        return modelMapper.map(estadioRequest, Estadio.class);
    }
}