package com.redone.aftas.models;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
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
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfFish;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competition_code")
    private Competition competition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fish_name")
    private Fish fish;


    public HuntingResponseDto mapToResponseDto(){
        return HuntingResponseDto.builder().competitionCode(competition.getCode())
                .memberNum(member.getNum())
                .fish(fish.mapToFishRespDto())
                .numberOfFish(numberOfFish)
                .build();
    }
}
