package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.GoalkeepingResponse;
import pl.Wlodarczyk.UCL_Stats.dto.GoalsResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.GoalkeepingMapper;
import pl.Wlodarczyk.UCL_Stats.repository.GoalkeepingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalkeepingService {
    private final GoalkeepingRepository goalkeepingRepository;
    private final GoalkeepingMapper goalkeepingMapper;

    @Transactional(readOnly = true)
    public GoalkeepingResponse getByPlayerId(Long playerId){
        return goalkeepingRepository.findById(playerId)
                .map(goalkeepingMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<GoalkeepingResponse> getTopXBySaves(Integer x){
        return getTopByField(x, "saves");
    }

    @Transactional(readOnly = true)
    public List<GoalkeepingResponse> getTopXByGoalsConceded(Integer x){
        return getTopByField(x, "goalsConceded");
    }

    @Transactional(readOnly = true)
    public List<GoalkeepingResponse> getTopXBySavesOnPenalty(Integer x){
        return getTopByField(x, "savesOnPenalty");
    }

    @Transactional(readOnly = true)
    public List<GoalkeepingResponse> getTopXByCleanSheets(Integer x){
        return getTopByField(x, "cleanSheets");
    }

    @Transactional(readOnly = true)
    public List<GoalkeepingResponse> getTopXByPunchesMade(Integer x){
        return getTopByField(x, "punchesMade");
    }


    private List<GoalkeepingResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return goalkeepingRepository.findAll(pageable).stream()
                .map(goalkeepingMapper::toResponse)
                .toList();
    }

}
