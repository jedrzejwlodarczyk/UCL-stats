package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "players_data")
@Getter @Setter @NoArgsConstructor
public class Player {
    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "field_position")
    private String fieldPosition;

    @Column(name = "position")
    private String position;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team", nullable = false)
    private Team team;

    @Column(name = "player_image")
    private String playerImage;
}
