package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players_stats")
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
}
