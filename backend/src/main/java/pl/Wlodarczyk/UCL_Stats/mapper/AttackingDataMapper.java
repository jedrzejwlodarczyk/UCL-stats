package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.model.AttackingData;

@Mapper(componentModel = "spring")
public interface AttackingDataMapper {

    @Mapping(source = "player.playerName", target = "name")
    AttackingDataResponse toResponse(AttackingData attackingData);
}
