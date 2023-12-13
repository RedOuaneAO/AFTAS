package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.CompetitionRequestDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.repositories.CompetitionRepository;
import com.redone.aftas.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public Competition addCompetition(CompetitionRequestDto competitionRequestDto) {

        return competitionRepository.save(competitionRequestDto.mapToCompetitionEntity());
    }

    @Override
    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }
}
