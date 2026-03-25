package pl.Wlodarczyk.UCL_Stats.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public record DefendingResponse(
        String name,
        Integer ballsRecovered,
        Integer tackles,
        Integer tacklesWon,
        Integer tacklesLost,
        Integer clearanceAttempted
) {
}
