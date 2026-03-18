package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.Wlodarczyk.UCL_Stats.repository.PlayerRepository;

@Entity
@Table(name = "attacking_data")
@Getter @Setter @NoArgsConstructor
public class AttackingData {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
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
