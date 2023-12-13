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
    private Long competitionId;
    private  Long memberId;
    private Long fishId;
    public Hunting mapToHuntingEntity(){
        return Hunting.builder()
                .numberOfFish(numberOfFish)
                .member(Member.builder().id(memberId).build())
                .competition(Competition.builder().id(competitionId).build())
                .fish(Fish.builder().id(fishId).build())
                .build();
    }
}
