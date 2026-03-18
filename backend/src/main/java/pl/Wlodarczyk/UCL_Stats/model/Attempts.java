package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "attempts_data")
@Getter @Setter @NoArgsConstructor
public class Attempts {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "total_attempts")
    private Integer totalAttempts;

    @Column(name = "attempts_on_target")
    private Integer attemptsOnTarget;

    @Column(name = "attempts_off_target")
    private Integer attemptsOffTarget;

    @Column(name = "blocked")
    private Integer blocked;

}
