package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.dto.KeyStatsResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.KeyStatsMapper;
import pl.Wlodarczyk.UCL_Stats.repository.KeyStatsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyStatsService {
    private final KeyStatsRepository keyStatsRepository;
    private final KeyStatsMapper keyStatsMapper;

    @Transactional(readOnly = true)
    public KeyStatsResponse getByPlayerId(Long playerId){
        return keyStatsRepository.findById(playerId)
                .map(keyStatsMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }

    @Transactional(readOnly = true)
    public List<KeyStatsResponse> getTopXDistanceCovered(Integer x){
        return getTopByField(x, "distanceCovered");
    }

    @Transactional(readOnly = true)
    public List<KeyStatsResponse> getTopXTopSpeed(Integer x){
        return getTopByField(x, "topSpeed");
    }

    @Transactional(readOnly = true)
    public List<KeyStatsResponse> getTopXMinutesPlayed(Integer x){
        return getTopByField(x, "minutesPlayed");
    }

    @Transactional(readOnly = true)
    public List<KeyStatsResponse> getTopXMatchesAppareance(Integer x){
        return getTopByField(x, "matchesAppareance");
    }

    private List<KeyStatsResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return keyStatsRepository.findAll(pageable).stream()
                .map(keyStatsMapper::toResponse)
                .toList();
    }
}
