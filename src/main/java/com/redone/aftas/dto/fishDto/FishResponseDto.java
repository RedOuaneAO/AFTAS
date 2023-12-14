package com.redone.aftas.dto.fishDto;

import com.redone.aftas.models.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FishResponseDto {

    private String name;
    private Double averageWeight;
    private Level level;
}
