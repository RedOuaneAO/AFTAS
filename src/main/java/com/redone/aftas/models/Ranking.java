package com.redone.aftas.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.redone.aftas.dto.rankingDto.RankingRequestDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
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
    @JoinColumn(name = "competition_code")
    private Competition competition;

    @ManyToOne

    @JoinColumn(name = "member_num")
    @MapsId("memberNum")
    private Member member;

public RankingRequestDto mapToReqDto(){
   return RankingRequestDto.builder()
           .rank(rank)
           .score(score)
           .memberNum(member.getNum())
           .competitionCode(competition.getCode())
           .build();
}
public RankingResponseDto mapToRespDto(){
    return RankingResponseDto.builder()
            .competitionCode(competition.getCode())
            .rank(rank)
            .score(score)
            .member(member.mepToMRDto())
            .build();
}
}
