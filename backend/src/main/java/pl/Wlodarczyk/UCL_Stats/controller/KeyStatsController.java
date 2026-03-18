package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.Wlodarczyk.UCL_Stats.dto.KeyStatsResponse;
import pl.Wlodarczyk.UCL_Stats.service.KeyStatsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/key-stats")
@RequiredArgsConstructor
public class KeyStatsController {
    private final KeyStatsService keyStatsService;

    @GetMapping("/player/{playerId}")
    public KeyStatsResponse getByPlayerId(@PathVariable Long playerId){
        return keyStatsService.getByPlayerId(playerId);
    }

    @GetMapping("/distance/{size}")
    public List<KeyStatsResponse> getDistance(@PathVariable Integer size){
        return keyStatsService.getTopXDistanceCovered(size);
    }

    @GetMapping("/top-speed/{size}")
    public List<KeyStatsResponse> getTopSpeed(@PathVariable Integer size){
        return keyStatsService.getTopXTopSpeed(size);
    }

    @GetMapping("/minutes/{size}")
    public List<KeyStatsResponse> getMinutes(@PathVariable Integer size){
        return keyStatsService.getTopXMinutesPlayed(size);
    }

    @GetMapping("/matches/{size}")
    public List<KeyStatsResponse> getDistances(@PathVariable Integer size){
        return keyStatsService.getTopXMatchesAppareance(size);
    }


}
