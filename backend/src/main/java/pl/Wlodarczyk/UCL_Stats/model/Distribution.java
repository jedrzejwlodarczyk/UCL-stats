package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "distribution_data")
@Getter @Setter @NoArgsConstructor
public class Distribution {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "passing_accuracy")
    private BigDecimal passingAccuracy;

    @Column(name = "passes_attempted")
    private Integer passesAttempted;

    @Column(name = "passes_completed")
    private Integer passesCompleted;

    @Column(name = "crossing_accuracy")
    private BigDecimal crossingAccuracy;

    @Column(name = "crosses_attempted")
    private Integer crossesAttempted;

    @Column(name = "crosses_completed")
    private Integer crossesCompleted;

    @Column(name = "free_kick_taken")
    private Integer freeKickTaken;

    @Column(name = "matches_appearance")
    private Integer matchesAppearance;
}
