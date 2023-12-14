package com.redone.aftas.services;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
import com.redone.aftas.models.Ranking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankingService {
    Ranking addRank(ParticipateInCompetitionDto participateInCompetitionDto);

    List<Ranking> getAllRanks();

//    List<HuntingResponseDto> getScore(String competitionCode);


}
