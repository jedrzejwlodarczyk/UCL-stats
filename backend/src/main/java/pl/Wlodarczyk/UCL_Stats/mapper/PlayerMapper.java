package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.PlayerResponse;
import pl.Wlodarczyk.UCL_Stats.model.Player;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "team.team", target = "teamName")
    PlayerResponse toResponse(Player player);
}
