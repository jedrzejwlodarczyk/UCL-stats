package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "defending_data")
@Getter @Setter @NoArgsConstructor
public class Defending {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "balls_recovered")
    private Integer ballsRecovered;

    @Column(name = "tackles")
    private Integer tackles;

    @Column(name = "tackles_won")
    private Integer tacklesWon;

    @Column(name = "tackles_lost")
    private Integer tacklesLost;

    @Column(name = "clearance_attempted")
    private Integer clearanceAttempted;
}
