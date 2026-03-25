package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.PlayerResponse;
import pl.Wlodarczyk.UCL_Stats.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/{playerId}")
    public PlayerResponse getById(@PathVariable Long playerId){
        return playerService.getById(playerId);
    }

    @GetMapping("/team/{teamId}")
    public List<PlayerResponse> getByTeam(@PathVariable Long teamId){
        return playerService.getByTeam(teamId);
    }
}
