package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "goalkeeping_data")
@Getter @Setter @NoArgsConstructor
public class Goalkeeping {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player")
    private Player player;

    @Column(name = "saves")
    private Integer saves;

    @Column(name = "goals_conceded")
    private Integer goalsConceded;

    @Column(name = "saves_on_penalty")
    private Integer savesOnPenalty;

    @Column(name = "clean_sheets")
    private Integer cleanSheets;

    @Column(name = "punches_made")
    private Integer punchesMade;
}
