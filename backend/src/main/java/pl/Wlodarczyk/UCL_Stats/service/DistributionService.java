package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.DisciplinaryResponse;
import pl.Wlodarczyk.UCL_Stats.dto.DistributionResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.DistributionMapper;
import pl.Wlodarczyk.UCL_Stats.repository.DistributionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistributionService {
    private final DistributionRepository distributionRepository;
    private final DistributionMapper distributionMapper;

    @Transactional(readOnly = true)
    public DistributionResponse getByPlayerId(Long playerId){
        return distributionRepository.findById(playerId)
                .map(distributionMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByPassingAccuracy(Integer x){
        return getTopByFieldForAccuracy(x, "passingAccuracy", "passesCompleted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByPassingAttempted(Integer x){
        return getTopByField(x, "passesAttempted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByPassingCompleted(Integer x){
        return getTopByField(x, "passesCompleted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByCrossingAccuracy(Integer x){
        return getTopByFieldForAccuracy(x, "crossingAccuracy", "crossesCompleted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByCrossingAttempted(Integer x){

        return getTopByField(x, "crossesAttempted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByCrossingCompleted(Integer x){
        return getTopByField(x, "crossesCompleted");
    }

    @Transactional(readOnly = true)
    public List<DistributionResponse> getTopXByFreeKickTaken(Integer x){
        return getTopByField(x, "freeKickTaken");
    }


    private List<DistributionResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return distributionRepository.findAll(pageable).stream()
                .map(distributionMapper::toResponse)
                .toList();
    }

    private List<DistributionResponse> getTopByFieldForAccuracy(Integer x, String fieldName, String completedField) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.desc(completedField).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return distributionRepository.findAll(pageable).stream()
                .map(distributionMapper::toResponse)
                .toList();
    }
}
