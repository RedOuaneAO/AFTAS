package com.redone.aftas.dto;

import com.redone.aftas.models.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LevelRequestDto {

    private String description;
    private Integer points;

    public Level mapToLevelEntity(){
        return Level.builder()
                .description(description)
                .points(points)
                .build();
    }
}
