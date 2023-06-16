package api.mapper;

import api.dto.input.CampeonatoRequest;
import api.dto.output.CampeonatoResponse;
import domain.model.Campeonato;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampeonatoMapperAdapter {

    private final ModelMapper modelMapper;

    public CampeonatoMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CampeonatoResponse toCampeonatoResponse(Campeonato campeonato) {
        return modelMapper.map(campeonato, CampeonatoResponse.class);
    }

    public List<CampeonatoResponse> toCampeonatoResponseList(List<Campeonato> campeonatos) {
        return campeonatos.stream()
                .map(this::toCampeonatoResponse)
                .collect(Collectors.toList());
    }

    public Campeonato toCampeonato(CampeonatoRequest campeonatoRequest) {
        return modelMapper.map(campeonatoRequest, Campeonato.class);
    }

}
