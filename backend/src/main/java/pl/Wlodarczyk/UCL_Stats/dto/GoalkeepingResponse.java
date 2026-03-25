package pl.Wlodarczyk.UCL_Stats.dto;

public record GoalkeepingResponse(
        String name,
        Integer saves,
        Integer goalsConceded,
        Integer savesOnPenalty,
        Integer cleanSheets,
        Integer punchesMade
) {

}

