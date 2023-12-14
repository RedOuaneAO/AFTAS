package com.redone.aftas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.dto.fishDto.FishResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Fish {
    @Id
    private String name;
    private Double averageWeight;
    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY)
    private List<Hunting> huntingList;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;

    public FishRequestDto mapToFishDto(){
        return FishRequestDto.builder()
                .name(name)
                .averageWeight(averageWeight)
                .levelCode(level.getCode())
                .build();
    }
    public FishResponseDto mapToFishRespDto(){
        return FishResponseDto.builder()
                .name(name)
                .averageWeight(averageWeight)
                .level(level)
                .build();
    }
}
