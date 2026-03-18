package pl.Wlodarczyk.UCL_Stats.dto;

public record AttemptsResponse(
        String name,
        Integer totalAttempts,
        Integer attemptsOnTarget,
        Integer attemptsOffTarget,
        Integer blocked
) {
}
