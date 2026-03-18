package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.AttackingDataResponse;
import pl.Wlodarczyk.UCL_Stats.dto.AttemptsResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.AttemptsMapper;
import pl.Wlodarczyk.UCL_Stats.repository.AttemptsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttemptsService {
    private final AttemptsRepository attemptsRepository;
    private final AttemptsMapper attemptsMapper;

    @Transactional(readOnly = true)
    public AttemptsResponse getByPlayerId(Long playerId){
        return attemptsRepository.findById(playerId)
                .map(attemptsMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<AttemptsResponse> getTopXByTotalAttempts(Integer x){
        return getTopByField(x, "totalAttempts");
    }

    @Transactional(readOnly = true)
    public List<AttemptsResponse> getTopXByAttemptsOnTarget(Integer x){
        return getTopByField(x, "attemptsOnTarget");
    }

    @Transactional(readOnly = true)
    public List<AttemptsResponse> getTopXByAttemptsOffTarget(Integer x){
        return getTopByField(x, "attemptsOffTarget");
    }


    @Transactional(readOnly = true)
    public List<AttemptsResponse> getTopXByBlocked(Integer x){
        return getTopByField(x, "blocked");
    }


    private List<AttemptsResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return attemptsRepository.findAll(pageable).stream()
                .map(attemptsMapper::toResponse)
                .toList();
    }
}
