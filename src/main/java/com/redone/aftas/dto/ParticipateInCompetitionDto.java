package com.redone.aftas.dto;

import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.RankId;
import com.redone.aftas.models.Ranking;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ParticipateInCompetitionDto {
    @NotNull(message = "competition cannot be null.")
    private String competitionCode;
    @NotNull(message = "member cannot be null.")
    private Integer memberNum;
    public Ranking mapToRankingEntity2(){
        return Ranking.builder().id(RankId.builder().competitionCode(competitionCode).memberNum(memberNum).build())
                .competition(Competition.builder().code(competitionCode).build())
                .member(Member.builder().num(memberNum).build())
                .build();
    }

}
