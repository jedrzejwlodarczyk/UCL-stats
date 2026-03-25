package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.AttemptsResponse;
import pl.Wlodarczyk.UCL_Stats.service.AttemptsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attempts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AttemptsController {
    private final AttemptsService attemptsService;


    @GetMapping("/player/{playerId}")
    public AttemptsResponse getByPlayerId(@PathVariable Long playerId){
        return attemptsService.getByPlayerId(playerId);
    }

    @GetMapping("/total/{size}")
    public List<AttemptsResponse> getTotal(@PathVariable Integer size){
        return attemptsService.getTopXByTotalAttempts(size);
    }

    @GetMapping("/on-target/{size}")
    public List<AttemptsResponse> getOnTarget(@PathVariable Integer size){
        return attemptsService.getTopXByAttemptsOnTarget(size);
    }

    @GetMapping("/off-target/{size}")
    public List<AttemptsResponse> getOffTarget(@PathVariable Integer size){
        return attemptsService.getTopXByAttemptsOffTarget(size);
    }

    @GetMapping("/blocked/{size}")
    public List<AttemptsResponse> getBlocked(@PathVariable Integer size){
        return attemptsService.getTopXByBlocked(size);
    }
}
