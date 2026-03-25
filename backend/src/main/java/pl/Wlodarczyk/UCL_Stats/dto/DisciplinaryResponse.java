package pl.Wlodarczyk.UCL_Stats.dto;

public record DisciplinaryResponse(
        String name,
        Integer foulsCommitted,
        Integer foulsSuffered,
        Integer yellowCards,
        Integer redCards
) {
}
