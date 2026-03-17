package pl.Wlodarczyk.UCL_Stats.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public record AttackingDataResponse(
        String name,
        Integer assists,
        Integer cornersTaken,
        Integer offsides,
        Integer dribbles
) {
}
