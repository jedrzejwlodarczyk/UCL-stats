package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.GoalsResponse;
import pl.Wlodarczyk.UCL_Stats.model.Goals;

@Mapper(componentModel = "spring")
public interface GoalsMapper {
    @Mapping(source = "player.playerName", target = "name")
    GoalsResponse toResponse(Goals goals);
}
