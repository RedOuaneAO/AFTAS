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

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ParticipateInCompetitionDto {
    @NotNull(message = "competition cannot be null.")
    private String competitionCode;
    @NotNull(message = "member cannot be null.")
    private List<Integer> memberNum;

        public List<Ranking> mapToRankingEntity2(){
            List<Ranking> rankings =new ArrayList<>();
            for (Integer member:memberNum) {
                Ranking ranking= Ranking.builder()
                        .id(RankId.builder().competitionCode(competitionCode).memberNum(member).build())
                        .competition(Competition.builder().code(competitionCode).build())
                        .member(Member.builder().num(member).build())
                        .build();
                rankings.add(ranking);
            }
            return rankings;
        }

}
