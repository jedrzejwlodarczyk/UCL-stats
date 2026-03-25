package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.DefendingResponse;
import pl.Wlodarczyk.UCL_Stats.service.DefendingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/defending")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DefendingController {
    private final DefendingService defendingService;

    @GetMapping("/player/{playerId}")
    public DefendingResponse getByPlayerId(@PathVariable Long playerId){
        return defendingService.getByPlayerId(playerId);
    }

    @GetMapping("/balls-recovered/{size}")
    private List<DefendingResponse> getBallsRecovered(@PathVariable Integer size){
        return defendingService.getTopXByBallsRecovered(size);
    }
}
