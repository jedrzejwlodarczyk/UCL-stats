package pl.Wlodarczyk.UCL_Stats.dto;

import jakarta.persistence.*;
import pl.Wlodarczyk.UCL_Stats.model.Team;

import java.math.BigDecimal;

public record PlayerResponse(
        String playerName,
        String nationality,
        String fieldPosition,
        String position,
        BigDecimal weight,
        BigDecimal height,
        Integer age,
        String teamName,
        String playerImage
) {
}
