package com.redone.aftas.services;

import com.redone.aftas.dto.CompetitionRequestDto;
import com.redone.aftas.models.Competition;
import org.springframework.stereotype.Service;

@Service
public interface CompetitionService {
    Competition addCompetition(CompetitionRequestDto competitionRequestDto);
}
