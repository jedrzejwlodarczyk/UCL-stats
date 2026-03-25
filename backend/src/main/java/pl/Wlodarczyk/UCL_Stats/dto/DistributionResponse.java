package pl.Wlodarczyk.UCL_Stats.dto;

import java.math.BigDecimal;

public record DistributionResponse(
        String name,
        BigDecimal passingAccuracy,
        Integer passesAttempted,
        Integer passesCompleted,
        BigDecimal crossingAccuracy,
        Integer crossesAttempted,
        Integer crossesCompleted,
        Integer freeKickTaken
) {
}
