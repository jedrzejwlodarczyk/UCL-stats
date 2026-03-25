package pl.Wlodarczyk.UCL_Stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.Wlodarczyk.UCL_Stats.dto.DistributionResponse;
import pl.Wlodarczyk.UCL_Stats.model.Distribution;

@Mapper(componentModel = "spring")
public interface DistributionMapper {
    @Mapping(source = "player.playerName", target = "name")
    DistributionResponse toResponse(Distribution distribution);
}
