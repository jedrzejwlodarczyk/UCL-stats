package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.DisciplinaryResponse;
import pl.Wlodarczyk.UCL_Stats.service.DisciplinaryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplinary")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DisciplinaryController {
    private final DisciplinaryService disciplinaryService;

    @GetMapping("/player/{playerId}")
    public DisciplinaryResponse getByPlayerId(@PathVariable Long playerId){
        return disciplinaryService.getByPlayerId(playerId);
    }

    @GetMapping("/fouls-committed/{size}")
    public List<DisciplinaryResponse> getByFoulsCommited(@PathVariable Integer size){
        return disciplinaryService.getTopXFByFoulsCommited(size);
    }

    @GetMapping("/fouls-suffered/{size}")
    public List<DisciplinaryResponse> getByFoulsSuffered(@PathVariable Integer size){
        return disciplinaryService.getTopXFByFoulsSuffered(size);
    }

    @GetMapping("/yellow-cards/{size}")
    public List<DisciplinaryResponse> getByYellowCards(@PathVariable Integer size){
        return disciplinaryService.getTopXFByYellowCards(size);
    }

    @GetMapping("/red-cards/{size}")
    public List<DisciplinaryResponse> getByRedCards(@PathVariable Integer size){
        return disciplinaryService.getTopXFByRedCards(size);
    }
}
