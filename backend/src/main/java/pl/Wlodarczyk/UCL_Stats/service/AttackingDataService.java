package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.AttackingDataMapper;
import pl.Wlodarczyk.UCL_Stats.repository.AttackingDataRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttackingDataService {
    private final AttackingDataRepository attackingDataRepository;
    private final AttackingDataMapper attackingDataMapper;

    @Transactional(readOnly = true)
    public AttackingDataResponse getByPlayerId(Long playerId){
        return attackingDataRepository.findById(playerId)
                .map(attackingDataMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }

    @Transactional(readOnly = true)
    public List<AttackingDataResponse> getTopXByAssists(Integer x){
        return getTopByField(x, "assists");
    }

    @Transactional(readOnly = true)
    public List<AttackingDataResponse> getTopXByCornersTaken(Integer x){
        return getTopByField(x, "cornersTaken");
    }

    @Transactional(readOnly = true)
    public List<AttackingDataResponse> getTopXByOffsides(Integer x){
        return getTopByField(x, "offsides");
    }

    @Transactional(readOnly = true)
    public List<AttackingDataResponse> getTopXByDribbles(Integer x){
        return getTopByField(x, "dribbles");
    }

    private List<AttackingDataResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return attackingDataRepository.findAll(pageable).stream()
                .map(attackingDataMapper::toResponse)
                .toList();
    }
}
