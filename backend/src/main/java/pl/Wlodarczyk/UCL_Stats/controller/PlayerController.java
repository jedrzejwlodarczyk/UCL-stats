package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.Wlodarczyk.UCL_Stats.dto.PlayerResponse;
import pl.Wlodarczyk.UCL_Stats.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/team")
    public List<PlayerResponse> getByTeam(@RequestParam Long team){
        return playerService.getByTeam(team);
    }
}
