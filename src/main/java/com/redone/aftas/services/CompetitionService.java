package com.redone.aftas.services;

import com.redone.aftas.dto.competitionDto.CompetitionRequestDto;
import com.redone.aftas.dto.competitionDto.CompetitionResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetitionService {
    Competition addCompetition(CompetitionRequestDto competitionRequestDto);

    List<CompetitionResponseDto> getCompetitions();


    Page<Competition> getCompetitionsPaginated(Pageable pageable);
}
