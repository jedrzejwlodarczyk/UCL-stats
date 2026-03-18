package pl.Wlodarczyk.UCL_Stats.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.dto.PlayerResponse;
import pl.Wlodarczyk.UCL_Stats.mapper.PlayerMapper;
import pl.Wlodarczyk.UCL_Stats.repository.PlayerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Transactional(readOnly = true)
    public PlayerResponse getById(Long playerId){
        return playerRepository.findById(playerId)
                .map(playerMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));
    }

    @Transactional(readOnly = true)
    public List<PlayerResponse> getByTeam(Long teamId){
        return playerRepository.findByTeamTeamId(teamId).stream()
                .map(playerMapper::toResponse)
                .toList();
    }
}
