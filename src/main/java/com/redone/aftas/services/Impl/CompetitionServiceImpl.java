package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.competitionDto.CompetitionRequestDto;
import com.redone.aftas.dto.competitionDto.CompetitionResponseDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.repositories.CompetitionRepository;
import com.redone.aftas.repositories.RankingRepository;
import com.redone.aftas.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public Competition addCompetition(CompetitionRequestDto competitionRequestDto) {
        if(competitionRequestDto.getStartTime().isAfter(competitionRequestDto.getEndTime())){
            throw new RuntimeException("the start time cannot be after end time");
        }
        if(competitionRepository.existsByDate(competitionRequestDto.getDate())){
            throw  new RuntimeException("you have already a competition in this date");
        }
        if(Duration.between(competitionRequestDto.getStartTime(), competitionRequestDto.getEndTime()).toHours() < 2 ){
            throw new RuntimeException("The competition must be at least 2 hours long");
        }
        if(competitionRequestDto.getDate().minus(Period.ofDays(2)).isBefore(LocalDate.now())){
            throw new RuntimeException("The competition must at least be in 2 days from now");
        }

        String competitionCode =generateCompetitionCode(competitionRequestDto.getLocation() , competitionRequestDto.getDate());
        Competition competition =competitionRequestDto.mapToCompetitionEntity();
        competition.setCode(competitionCode);
        return competitionRepository.save(competition);
    }
    public String generateCompetitionCode(String location, LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        String formattedDate = dateFormatter.format(date).toLowerCase();
        String locationCode = location.substring(0, Math.min(location.length(), 3)).toLowerCase();
        return locationCode+"-"+ formattedDate;
    }

    @Override
    public List<CompetitionResponseDto> getCompetitions() {
        return competitionRepository.findAll().stream().map(competition -> competition
                .mapToCompResponseDto()).collect(Collectors.toList());
    }

    @Override
    public Page<Competition> getCompetitionsPaginated(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }


}
