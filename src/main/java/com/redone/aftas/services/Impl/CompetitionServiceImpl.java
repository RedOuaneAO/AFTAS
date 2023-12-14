package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.CompetitionRequestDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.repositories.CompetitionRepository;
import com.redone.aftas.repositories.RankingRepository;
import com.redone.aftas.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final RankingRepository rankingRepository;
    @Override
    public Competition addCompetition(CompetitionRequestDto competitionRequestDto) {
        if(competitionRequestDto.getStartTime().isAfter(competitionRequestDto.getEndTime())){
            throw new RuntimeException("the start time cannot be after end time");
        }
        if(competitionRepository.existsByDate(competitionRequestDto.getDate())){
            throw  new RuntimeException("you have already a competition in this date");
        }
        return competitionRepository.save(competitionRequestDto.mapToCompetitionEntity());
    }

    @Override
    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }

}
