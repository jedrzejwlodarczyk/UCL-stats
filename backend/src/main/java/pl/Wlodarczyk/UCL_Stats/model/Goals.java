package pl.Wlodarczyk.UCL_Stats.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "goals_data")
@Getter @Setter @NoArgsConstructor
public class Goals {

    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "inside_area")
    private Integer insideArea;

    @Column(name = "outside_area")
    private Integer outsideArea;

    @Column(name = "right_food")
    private Integer rightFood;

    @Column(name = "left_food")
    private Integer leftFood;

    @Column(name = "head")
    private Integer head;

    @Column(name = "other")
    private Integer other;

    @Column(name = "penalties_scored")
    private Integer penaltiesScored;
}
