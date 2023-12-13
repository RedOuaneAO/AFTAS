package com.redone.aftas.dto;


import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.RankId;
import com.redone.aftas.models.Ranking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RankingRequestDto {
    private int rank;
    private int score;
    private String competitionCode;
    private Integer memberNum;
    public Ranking mapToRankingEntity(){
        return Ranking.builder().id(RankId.builder().competitionCode(competitionCode).memberNum(memberNum).build())
                .competition(Competition.builder().code(competitionCode).build())
                .member(Member.builder().num(memberNum).build())
                .rank(rank)
                .score(score)
                .build();
    }

}
