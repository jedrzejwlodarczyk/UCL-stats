package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.AttemptsResponse;
import pl.Wlodarczyk.UCL_Stats.dto.DefendingResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.DefendingMapper;
import pl.Wlodarczyk.UCL_Stats.repository.DefendingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefendingService {
    private final DefendingRepository defendingRepository;
    private final DefendingMapper defendingMapper;

    @Transactional(readOnly = true)
    public DefendingResponse getByPlayerId(Long playerId){
        return defendingRepository.findById(playerId)
                .map(defendingMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<DefendingResponse> getTopXByBallsRecovered(Integer x){
        return getTopByField(x, "ballsRecovered");
    }

    @Transactional(readOnly = true)
    public List<DefendingResponse> getTopXByTackles(Integer x){
        return getTopByField(x, "tackles");
    }

    @Transactional(readOnly = true)
    public List<DefendingResponse> getTopXByTacklesWon(Integer x){
        return getTopByField(x, "tacklesWon");
    }

    @Transactional(readOnly = true)
    public List<DefendingResponse> getTopXByTacklesLost(Integer x){
        return getTopByField(x, "tacklesLost");
    }

    @Transactional(readOnly = true)
    public List<DefendingResponse> getTopXByClearanceAttempted(Integer x){
        return getTopByField(x, "clearanceAttempted");
    }


    private List<DefendingResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return defendingRepository.findAll(pageable).stream()
                .map(defendingMapper::toResponse)
                .toList();
    }
}
