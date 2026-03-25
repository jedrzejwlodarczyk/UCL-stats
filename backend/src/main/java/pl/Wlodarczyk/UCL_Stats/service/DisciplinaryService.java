package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.DefendingResponse;
import pl.Wlodarczyk.UCL_Stats.dto.DisciplinaryResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.DisciplinaryMapper;
import pl.Wlodarczyk.UCL_Stats.repository.DisciplinaryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaryService {
    private final DisciplinaryRepository disciplinaryRepository;
    private final DisciplinaryMapper disciplinaryMapper;

    @Transactional(readOnly = true)
    public DisciplinaryResponse getByPlayerId(Long playerId){
        return disciplinaryRepository.findById(playerId)
                .map(disciplinaryMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<DisciplinaryResponse> getTopXFByFoulsCommited(Integer x){
        return getTopByField(x, "foulsCommitted");
    }

    @Transactional(readOnly = true)
    public List<DisciplinaryResponse> getTopXFByFoulsSuffered(Integer x){
        return getTopByField(x, "foulsSuffered");
    }

    @Transactional(readOnly = true)
    public List<DisciplinaryResponse> getTopXFByYellowCards(Integer x){
        return getTopByField(x, "yellowCards");
    }

    @Transactional(readOnly = true)
    public List<DisciplinaryResponse> getTopXFByRedCards(Integer x){
        return getTopByField(x, "redCards");
    }

    private List<DisciplinaryResponse> getTopByField(Integer x, String fieldName) {
        Sort sort = Sort.by(
                Sort.Order.desc(fieldName).nullsLast(),
                Sort.Order.asc("player.playerName")
        );
        Pageable pageable = PageRequest.of(0, x, sort);

        return disciplinaryRepository.findAll(pageable).stream()
                .map(disciplinaryMapper::toResponse)
                .toList();
    }
}
