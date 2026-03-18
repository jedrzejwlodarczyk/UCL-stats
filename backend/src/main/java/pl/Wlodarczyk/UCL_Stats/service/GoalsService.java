package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.dto.GoalsResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.GoalsMapper;
import pl.Wlodarczyk.UCL_Stats.repository.GoalsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalsService {
    private final GoalsRepository goalsRepository;
    public final GoalsMapper goalsMapper;

    @Transactional(readOnly = true)
    public GoalsResponse getByPlayerId(Long playerId){
        return goalsRepository.findById(playerId)
                .map(goalsMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByGoals(Integer x){
        return getTopByField(x, "goals");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByInsideArea(Integer x){
        return getTopByField(x, "insideArea");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByOutsideArea(Integer x){
        return getTopByField(x, "outsideArea");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByRightFood(Integer x){
        return getTopByField(x, "rightFood");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByLeftFood(Integer x){
        return getTopByField(x, "leftFood");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByHead(Integer x){
        return getTopByField(x, "head");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByOther(Integer x){
        return getTopByField(x, "other");
    }

    @Transactional(readOnly = true)
    public List<GoalsResponse> getTopXByPenaltiesScored(Integer x){
        return getTopByField(x, "penaltiesScored");
    }

    private List<GoalsResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return goalsRepository.findAll(pageable).stream()
                .map(goalsMapper::toResponse)
                .toList();
    }
}
