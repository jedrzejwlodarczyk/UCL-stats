package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import pl.Wlodarczyk.UCL_Stats.model.Team;
import pl.Wlodarczyk.UCL_Stats.dto.TeamResponse;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamResponse toResponse(Team team);
}
