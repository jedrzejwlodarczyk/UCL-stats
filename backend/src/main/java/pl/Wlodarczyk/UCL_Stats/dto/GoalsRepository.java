package pl.Wlodarczyk.UCL_Stats.dto;

public record GoalsRepository(
        String name,
        Integer goal,
        Integer insideArea,
        Integer outsideArea,
        Integer rightFood,
        Integer leftFood,
        Integer head,
        Integer other,
        Integer penaltiesScored
) {
}
