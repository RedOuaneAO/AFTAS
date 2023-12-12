package com.redone.aftas.dto;

import com.redone.aftas.models.Competition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompetitionRequestDto {
    private String code;
    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String localisation;
    private double amount;

    public Competition mapToCompetitionEntity(){
       return Competition.builder()
               .code(code).date(date)
               .startTime(startTime)
                .numberOfParticipants(numberOfParticipants)
                .amount(amount)
               .localisation(localisation).build();
    }
}
