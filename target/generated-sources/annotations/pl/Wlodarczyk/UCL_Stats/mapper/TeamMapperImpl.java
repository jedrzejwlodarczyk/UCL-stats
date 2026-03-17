package pl.Wlodarczyk.UCL_Stats.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.Wlodarczyk.UCL_Stats.dto.TeamResponse;
import pl.Wlodarczyk.UCL_Stats.model.Team;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-17T20:16:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamResponse toResponse(Team team) {
        if ( team == null ) {
            return null;
        }

        String country = null;
        String team1 = null;
        String logo = null;

        country = team.getCountry();
        team1 = team.getTeam();
        logo = team.getLogo();

        TeamResponse teamResponse = new TeamResponse( country, team1, logo );

        return teamResponse;
    }
}
