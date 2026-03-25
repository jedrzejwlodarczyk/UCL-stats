package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.DisciplinaryResponse;
import pl.Wlodarczyk.UCL_Stats.model.Disciplinary;

@Mapper(componentModel = "spring")
public interface DisciplinaryMapper {
    @Mapping(source = "player.playerName", target = "name")
    DisciplinaryResponse toResponse(Disciplinary disciplinary);
}
