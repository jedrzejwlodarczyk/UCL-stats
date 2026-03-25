package pl.Wlodarczyk.UCL_Stats.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.service.AttackingDataService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attacking-data")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AttackingDataController {
    private final AttackingDataService attackingDataService;

    @GetMapping("/player/{playerId}")
    public AttackingDataResponse getByPlayerId(@PathVariable Long playerId){
        return attackingDataService.getByPlayerId(playerId);
    }

    @GetMapping("/assists/{size}")
    public List<AttackingDataResponse> getAssists(@PathVariable Integer size){
        return attackingDataService.getTopXByAssists(size);
    }

    @GetMapping("/corners/{size}")
    public List<AttackingDataResponse> getCorners(@PathVariable Integer size){
        return attackingDataService.getTopXByCornersTaken(size);
    }

    @GetMapping("/offsides/{size}")
    public List<AttackingDataResponse> getOffsides(@PathVariable Integer size){
        return attackingDataService.getTopXByOffsides(size);
    }

    @GetMapping("/dribbles/{size}")
    public List<AttackingDataResponse> getDribbles(@PathVariable Integer size){
        return attackingDataService.getTopXByDribbles(size);
    }
}
