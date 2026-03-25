package pl.Wlodarczyk.UCL_Stats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.Wlodarczyk.UCL_Stats.dto.DistributionResponse;
import pl.Wlodarczyk.UCL_Stats.service.DistributionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/distribution")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DistributionController {
    private final DistributionService distributionService;

    @GetMapping("/player/{playerId}")
    public DistributionResponse getByPlayerId(@PathVariable Long playerId){
        return distributionService.getByPlayerId(playerId);
    }

    @GetMapping("/passing-accuracy/{size}")
    public List<DistributionResponse> getByPassingAccuracy(@PathVariable Integer size){
        return distributionService.getTopXByPassingAccuracy(size);
    }

    @GetMapping("/passes-attempted/{size}")
    public List<DistributionResponse> getByPassingAttempted(@PathVariable Integer size){
        return distributionService.getTopXByPassingAttempted(size);
    }

    @GetMapping("/passes-completed/{size}")
    public List<DistributionResponse> getByPassingCompleted(@PathVariable Integer size){
        return distributionService.getTopXByPassingCompleted(size);
    }

    @GetMapping("/crossing-accuracy/{size}")
    public List<DistributionResponse> getByCrossingAccuracy(@PathVariable Integer size){
        return distributionService.getTopXByCrossingAccuracy(size);
    }

    @GetMapping("/crosses-attempted/{size}")
    public List<DistributionResponse> getByCrossingAttempted(@PathVariable Integer size){
        return distributionService.getTopXByCrossingAttempted(size);
    }

    @GetMapping("/crosses-completed/{size}")
    public List<DistributionResponse> getByCrossingCompleted(@PathVariable Integer size){
        return distributionService.getTopXByCrossingCompleted(size);
    }

    @GetMapping("/free-kick-taken/{size}")
    public List<DistributionResponse> getByFreeKickTaken(@PathVariable Integer size){
        return distributionService.getTopXByFreeKickTaken(size);
    }
}
