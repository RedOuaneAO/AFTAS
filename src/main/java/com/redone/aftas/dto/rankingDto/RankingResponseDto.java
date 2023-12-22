package com.redone.aftas.dto.rankingDto;

import com.redone.aftas.dto.memberDto.MemberResponseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RankingResponseDto {
    private Integer rank;
    private Integer score;
    private String competitionCode;
    private MemberResponseDto member;
}
