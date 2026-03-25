package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.GoalkeepingResponse;
import pl.Wlodarczyk.UCL_Stats.model.Goalkeeping;

@Mapper(componentModel = "spring")
public interface GoalkeepingMapper {
    @Mapping(source = "player.playerName", target = "name")
    GoalkeepingResponse toResponse(Goalkeeping goalkeeping);
}
