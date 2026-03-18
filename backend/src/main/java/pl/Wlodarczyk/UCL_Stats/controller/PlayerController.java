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
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/{playerId}")
    public PlayerResponse getById(@PathVariable Long playerId){
        return playerService.getById(playerId);
    }

    @GetMapping("/team")
    public List<PlayerResponse> getByTeam(@RequestParam Long team){
        return playerService.getByTeam(team);
    }
}
