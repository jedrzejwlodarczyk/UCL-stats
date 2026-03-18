package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.dto.KeyStatsResponse;
import pl.Wlodarczyk.UCL_Stats.model.KeyStats;

@Mapper(componentModel = "spring")
public interface KeyStatsMapper {
    @Mapping(source = "player.playerName", target = "name")
    KeyStatsResponse toResponse(KeyStats keyStats);
}
