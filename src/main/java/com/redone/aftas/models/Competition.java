package com.redone.aftas.models;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;
    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "competition")
    private List<Hunting> huntingList;
}
