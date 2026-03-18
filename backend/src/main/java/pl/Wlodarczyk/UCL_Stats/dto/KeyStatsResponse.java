package pl.Wlodarczyk.UCL_Stats.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;

public record KeyStatsResponse(
        String name,
        BigDecimal distanceCovered,
        BigDecimal topSpeed,
        Integer minutesPlayed,
        Integer matchesAppareance
) {
}
