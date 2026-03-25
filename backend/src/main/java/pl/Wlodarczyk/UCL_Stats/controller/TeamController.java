package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.TeamResponse;
import pl.Wlodarczyk.UCL_Stats.service.TeamService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<TeamResponse> getAll(){
        return teamService.getAll();
    }

    @GetMapping("/name")
    public TeamResponse getByName(@RequestParam String name){
        return teamService.getByName(name);
    }
}
