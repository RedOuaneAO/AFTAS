package com.redone.aftas.dto.huntingDto;

import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.dto.fishDto.FishResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Fish;
import com.redone.aftas.models.Member;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HuntingResponseDto {

    private Integer numberOfFish;

    private String competitionCode;

    private Integer memberNum;

    private FishResponseDto fish;
}
