package pl.Wlodarczyk.UCL_Stats.dto;

public record TeamResponse(
        Long teamId,
        String country,
        String team,
        String logo
) {
}
