package com.redone.aftas.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Ranking {
    @EmbeddedId
    private RankId id;
    private Integer rank;
    private Integer score;

    @ManyToOne
    @JsonBackReference
    @MapsId("competitionCode")
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "member_id")
    @MapsId("memberNum")
    private Member member;
}
