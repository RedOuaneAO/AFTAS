package com.redone.aftas.dto;

import com.redone.aftas.models.Competition;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotNull(message = "Competition Code Cannot be Null.")
    @NotBlank(message = "Competition Code Cannot be Blank.")
    private String competitionCode;
    @NotNull(message = "Date Cannot be Null.")
    @Future(message = "Date Cannot be In The Past.")
    private LocalDate date;
    @NotNull(message = "Start Time Cannot be Null.")
    private LocalTime startTime;
    @NotNull(message = "End Time Cannot be Null.")
    private LocalTime endTime;
    @NotNull(message = "Number Of Participants Cannot be Null.")
    private Integer numberOfParticipants;
    @NotNull(message = "Location Cannot be Null.")
    private String location;
    @NotNull(message = "Location Cannot be Null.")
    @Positive(message = "The Amount cannot be a Negative Value")
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
