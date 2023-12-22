package com.redone.aftas.models;

import com.redone.aftas.dto.competitionDto.CompetitionResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Competition {
    @Id
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;
    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "competition" ,fetch = FetchType.LAZY)
    private List<Hunting> huntingList;


    public CompetitionResponseDto mapToCompResponseDto(){
        return CompetitionResponseDto.builder()
                .code(code)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .location(location)
                .amount(amount)
                .build();
    }
}
