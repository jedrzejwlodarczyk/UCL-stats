package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "key_stats_data")
@Getter @Setter @NoArgsConstructor
public class KeyStats {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "distance_covered")
    private BigDecimal distanceCovered;

    @Column(name = "top_speed")
    private BigDecimal topSpeed;

    @Column(name = "minutes_played")
    private Integer minutesPlayed;

    @Column(name = "matches_appareance")
    private Integer matchesAppareance;
}
