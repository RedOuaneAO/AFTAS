package com.redone.aftas.dto;

import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Fish;
import com.redone.aftas.models.Hunting;
import com.redone.aftas.models.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HuntingRequestDto {
    private int numberOfFish;
    private String competitionCode;
    private  Integer memberNum;
    private String fishName;
    public Hunting mapToHuntingEntity(){
        return Hunting.builder()
                .numberOfFish(numberOfFish)
                .member(Member.builder().num(memberNum).build())
                .competition(Competition.builder().code(competitionCode).build())
                .fish(Fish.builder().name(fishName).build())
                .build();
    }
}