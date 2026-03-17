package pl.Wlodarczyk.UCL_Stats.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.Wlodarczyk.UCL_Stats.mapper.TeamMapper;
import pl.Wlodarczyk.UCL_Stats.model.Team;
import pl.Wlodarczyk.UCL_Stats.repository.TeamRepository;
import pl.Wlodarczyk.UCL_Stats.dto.TeamResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Transactional(readOnly = true)
    public List<TeamResponse> getAll(){
        return teamRepository.findAll().stream()
                .map(teamMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public TeamResponse getByName(String name){
        return teamRepository.findByTeam(name)
                .map(teamMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Club " + name + " not found!"));
    }


}
