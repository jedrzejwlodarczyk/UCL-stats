package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.DefendingResponse;
import pl.Wlodarczyk.UCL_Stats.model.Defending;

@Mapper(componentModel = "spring")
public interface DefendingMapper {
    @Mapping(source = "player.playerName", target = "name")
    DefendingResponse toResponse(Defending defending);
}
