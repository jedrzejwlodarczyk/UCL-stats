package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import pl.Wlodarczyk.UCL_Stats.repository.PlayerRepository;

@Entity
@Table(name = "attacking_data")
public class AttackingData {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "corners_taken")
    private Integer cornersTaken;

    @Column(name = "offsides")
    private Integer offsides;

    @Column(name = "dribbles")
    private Integer dribbles;
}
