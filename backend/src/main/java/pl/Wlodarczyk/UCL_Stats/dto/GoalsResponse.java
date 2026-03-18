package pl.Wlodarczyk.UCL_Stats.dto;

public record GoalsResponse(
        String name,
        Integer goals,
        Integer insideArea,
        Integer outsideArea,
        Integer rightFood,
        Integer leftFood,
        Integer head,
        Integer other,
        Integer penaltiesScored
) {
}
