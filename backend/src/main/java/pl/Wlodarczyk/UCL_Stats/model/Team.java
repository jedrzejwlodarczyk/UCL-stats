package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams_data")
@Getter @Setter @NoArgsConstructor
public class Team {
    @Id
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "country")
    private String country;

    @Column(name = "team")
    private String team;

    @Column(name = "logo")
    private String logo;
}
