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
    private Long competitionId;
    private Long memberId;
    public Ranking mapToRankingEntity(){
        return Ranking.builder()
                .id(RankId.builder().competitionId(competitionId).memberId(memberId).build())
                .competition(Competition.builder().id(competitionId).build())
                .member(Member.builder().id(memberId).build())
                .rank(rank)
                .score(score)
                .build();
    }

}
