package api.mapper;

import api.dto.input.PartidaRequest;
import api.dto.output.PartidaResponse;
import domain.model.Partida;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class PartidaMapperAdapter {

    private final ModelMapper modelMapper;

    public PartidaMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PartidaResponse toPartidaResponse(Partida partida) {
        return modelMapper.map(partida, PartidaResponse.class);
    }

    public Partida toPartida(PartidaRequest partidaRequest) {
        return modelMapper.map(partidaRequest, Partida.class);
    }
}