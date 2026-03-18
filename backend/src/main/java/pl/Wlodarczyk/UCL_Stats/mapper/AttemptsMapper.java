package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.AttemptsResponse;
import pl.Wlodarczyk.UCL_Stats.model.Attempts;

@Mapper(componentModel = "spring")
public interface AttemptsMapper {
    @Mapping(source = "player.playerName", target = "name")
    AttemptsResponse toResponse(Attempts attempts);
}
