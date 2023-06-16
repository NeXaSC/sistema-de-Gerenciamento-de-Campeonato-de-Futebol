package api.mapper;

import api.dto.input.JogadorIdRequest;
import api.dto.output.JogadorNomeResponse;
import domain.model.Jogador;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JogadorMapperAdapter {

    private final ModelMapper modelMapper;

    public JogadorMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public JogadorNomeResponse toJogadorNomeResponse(Jogador jogador) {
        JogadorNomeResponse response = modelMapper.map(jogador, JogadorNomeResponse.class);
        response.setJogadorId(jogador.getId());
        return response;
    }

    public List<JogadorNomeResponse> toJogadorNomeResponseList(List<Jogador> jogadores) {
        return jogadores.stream()
                .map(this::toJogadorNomeResponse)
                .collect(Collectors.toList());
    }

    public Jogador toJogador(JogadorIdRequest jogadorRequest) {
        return modelMapper.map(jogadorRequest, Jogador.class);
    }
}