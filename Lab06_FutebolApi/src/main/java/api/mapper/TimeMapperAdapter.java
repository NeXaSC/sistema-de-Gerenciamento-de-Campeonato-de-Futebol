package api.mapper;


import api.dto.input.TimeRequest;
import api.dto.output.TimeResponse;
import domain.model.Time;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TimeMapperAdapter {

    private final ModelMapper modelMapper;

    public TimeMapperAdapter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TimeResponse toTimeResponse(Time time) {
        return modelMapper.map(time, TimeResponse.class);
    }

    public Time toTime(TimeRequest timeRequest) {
        return modelMapper.map(timeRequest, Time.class);
    }
}






