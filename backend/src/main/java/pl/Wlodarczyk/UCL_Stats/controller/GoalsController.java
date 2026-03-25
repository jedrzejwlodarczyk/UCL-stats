package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.GoalsResponse;
import pl.Wlodarczyk.UCL_Stats.service.GoalsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/goals")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GoalsController {
    private final GoalsService goalsService;

    @GetMapping("/player/{playerId}")
    public GoalsResponse getByPlayerId(@PathVariable Long playerId){
        return goalsService.getByPlayerId(playerId);
    }

    @GetMapping("/{size}")
    public List<GoalsResponse> getGoals(@PathVariable Integer size){
        return goalsService.getTopXByGoals(size);
    }

    @GetMapping("/inside-area/{size}")
    public List<GoalsResponse> getInsideArea(@PathVariable Integer size){
        return goalsService.getTopXByInsideArea(size);
    }

    @GetMapping("/outside-area/{size}")
    public List<GoalsResponse> getOutsideArea(@PathVariable Integer size){
        return goalsService.getTopXByOutsideArea(size);
    }

    @GetMapping("/right-food/{size}")
    public List<GoalsResponse> getRightFood(@PathVariable Integer size){
        return goalsService.getTopXByRightFood(size);
    }

    @GetMapping("/left-food/{size}")
    public List<GoalsResponse> getLeftFood(@PathVariable Integer size){
        return goalsService.getTopXByLeftFood(size);
    }

    @GetMapping("/head/{size}")
    public List<GoalsResponse> getHead(@PathVariable Integer size){
        return goalsService.getTopXByHead(size);
    }

    @GetMapping("/other/{size}")
    public List<GoalsResponse> getOther(@PathVariable Integer size){
        return goalsService.getTopXByOther(size);
    }

    @GetMapping("penalties/{size}")
    public List<GoalsResponse> getPenalties(@PathVariable Integer size){
        return goalsService.getTopXByPenaltiesScored(size);
    }
}
