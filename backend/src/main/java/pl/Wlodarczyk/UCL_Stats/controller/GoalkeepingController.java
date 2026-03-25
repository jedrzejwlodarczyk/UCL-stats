package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.GoalkeepingResponse;
import pl.Wlodarczyk.UCL_Stats.service.GoalkeepingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/goalkeeping")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GoalkeepingController {
    private final GoalkeepingService goalkeepingService;

    @GetMapping("/player/{playerId}")
    public GoalkeepingResponse getByPlayerId(@PathVariable Long playerId){
        return goalkeepingService.getByPlayerId(playerId);
    }

    @GetMapping("/saves/{size}")
    public List<GoalkeepingResponse> getBySaves(@PathVariable Integer size){
        return goalkeepingService.getTopXBySaves(size);
    }

    @GetMapping("/goals-conceded/{size}")
    public List<GoalkeepingResponse> getByGoalsConceded(@PathVariable Integer size){
        return goalkeepingService.getTopXByGoalsConceded(size);
    }

    @GetMapping("/saves-on-penalty/{size}")
    public List<GoalkeepingResponse> getBySavesOnPenalty(@PathVariable Integer size){
        return goalkeepingService.getTopXBySavesOnPenalty(size);
    }

    @GetMapping("/clean-sheets/{size}")
    public List<GoalkeepingResponse> getByCleanSheets(@PathVariable Integer size){
        return goalkeepingService.getTopXByCleanSheets(size);
    }

    @GetMapping("/punches-made/{size}")
    public List<GoalkeepingResponse> getByPunchesMade(@PathVariable Integer size){
        return goalkeepingService.getTopXByPunchesMade(size);
    }


}
