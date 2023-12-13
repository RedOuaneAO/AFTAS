package com.redone.aftas.dto;

import com.redone.aftas.models.Competition;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompetitionRequestDto {
    private String competitionCode;
    @NotNull(message = "date cannot be null.")
    @Future(message = "date cannot be in the past.")
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;

    public Competition mapToCompetitionEntity(){
       return Competition.builder()
               .code(competitionCode)
               .date(date)
               .startTime(startTime)
               .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .amount(amount)
               .location(location).build();
    }
}
