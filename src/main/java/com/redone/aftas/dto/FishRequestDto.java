package com.redone.aftas.dto;

import com.redone.aftas.models.Fish;
import com.redone.aftas.models.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FishRequestDto {
    private String name;
    private Double averageWeight;
    private Long levelId;

    public Fish mapToFishEntity(){
            return Fish.builder()
                    .name(name)
                    .averageWeight(averageWeight)
                    .level(Level.builder().id(levelId).build())
                    .build();
    }
}
