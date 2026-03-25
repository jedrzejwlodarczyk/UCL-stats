package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disciplinary_data")
@Getter @Setter @NoArgsConstructor
public class Disciplinary {
    @Column(name = "miss")
    private Integer miss;

    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "fouls_committed")
    private Integer foulsCommitted;

    @Column(name = "fouls_suffered")
    private Integer foulsSuffered;

    @Column(name = "yellow_cards")
    private Integer yellowCards;

    @Column(name = "red_cards")
    private Integer redCards;
}
